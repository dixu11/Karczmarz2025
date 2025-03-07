package repository;

import game.Dialog;
import game.ItemType;

import java.util.List;

public record NpcDto (String id, List<DialogDto> dialogs, List<NodeDto>nodes){
}

record DialogDto(int id, String text, String response, int changeNode, ItemType buyItem){

}

record NodeDto(int id,String name,List<Integer> dialogs){

}
