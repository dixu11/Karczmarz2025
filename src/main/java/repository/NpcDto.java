package repository;

import game.Dialog;

import java.util.List;

public record NpcDto (String id, List<DialogDto> dialogs, List<NodeDto>nodes){
}

record DialogDto(int id,String text, String response){

}

record NodeDto(int id,String name,List<Integer> dialogs){

}
