package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import game.Dialog;
import game.Node;
import game.Npc;
import game.NpcRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NpcJsonRepository implements NpcRepository {

    private static final String FILE_PATH = "/%s-npc.json";
    private NpcDto npcDto;
    private List<Dialog> allDialogs;
    private List<Node> nodes;
    private Npc npc;


    @Override
    public Npc getNpcById(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            npcDto = objectMapper.readValue(new File(getClass().getResource(
                            String.format(FILE_PATH, id.toLowerCase())
                    )
                    .getFile()), NpcDto.class);
            extractBusinessEntities();
            return npc;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load dialogs");
        }
    }

    private void extractBusinessEntities() {
        allDialogs = npcDto.dialogs().stream()
                .map(dialogDto -> new Dialog(dialogDto.id(), dialogDto.text(), dialogDto.response(),
                        dialogDto.buyItem(),dialogDto.visibility(),dialogDto.endsGame()))
                .toList();
        nodes = npcDto.nodes().stream()
                .map(nodeDto -> new Node(nodeDto.id(),createDialogsFromTheirIds(nodeDto.dialogs())))
                .toList();
        setChangeNodeOnDialog();
        npc = new Npc(npcDto.id(),
                npcDto.greeting(),
                allDialogs,
                nodes);
    }

    private List<Dialog> createDialogsFromTheirIds(List<Integer> dialogIds) {
        return dialogIds.stream()
                .map(dialogId -> allDialogs.stream()
                        .filter(dialog -> dialog.getId() == dialogId)
                        .findAny()
                        .orElseThrow())
                .toList();
    }

    private void setChangeNodeOnDialog() {
        npcDto.dialogs().stream()
                .filter(dialogDto -> dialogDto.changeNode() != 0)
                .forEach(dialogDto -> findDialogById(dialogDto.id())
                        .setChangeNode(findNodeById(dialogDto.changeNode())));
    }

    private Dialog findDialogById(int id) {
        return allDialogs.stream()
                .filter(dialog -> dialog.getId() == id)
                .findAny()
                .orElseThrow();
    }

    private Node findNodeById(int id){
        return nodes.stream()
                .filter(node -> node.getId() == id)
                .findAny()
                .orElseThrow();
    }

}
