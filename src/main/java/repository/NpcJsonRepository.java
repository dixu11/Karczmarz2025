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


    @Override
    public Npc getNpcById(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            NpcDto npcDto = objectMapper.readValue(new File(getClass().getResource(
                            String.format(FILE_PATH, id)
                    )
                    .getFile()), NpcDto.class);
            return toNpc(npcDto);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load dialogs");
        }
    }

    private Npc toNpc(NpcDto npcDto) {
        List<Dialog> allDialogs = npcDto.dialogs().stream()
                .map(dialogDto -> new Dialog(dialogDto.id(), dialogDto.text(), dialogDto.response()))
                .toList();
        return new Npc(npcDto.id(),
                allDialogs,
                npcDto.nodes().stream()
                        .map(node -> new Node(toDialogs(node.dialogs(), allDialogs)))
                        .toList());
    }

    private List<Dialog> toDialogs(List<Integer> dialogIds, List<Dialog> dialogs) {
        return dialogIds.stream()
                .map(dialogId -> dialogs.stream()
                        .filter(dialog -> dialog.getId() == dialogId)
                        .findAny()
                        .orElseThrow())
                .toList();
    }
}
