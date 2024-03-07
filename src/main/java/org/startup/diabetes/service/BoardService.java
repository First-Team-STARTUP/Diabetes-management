package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.repository.BoardRepository;
import org.startup.diabetes.repository.FastingRepository;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service //어노테이션붙여줘서 스프링이 관리하는 객체인 빈으로 등록시켜주고~!. ㅋ  조아..  컨트롤러도 안붙이니 스프링이 관리안해서 따로놀더라..
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final FastingRepository fastingRepository;



    // 사용자가 속한 게시판 그룹을 가져오는 메서드
    public List<Board> getBoardGroups(String userid) {
        return boardRepository.findByMemberUserid(userid);
    }


    //생성자주입받고,
    public void save(BoardDTO boardDTO) {
        Board board = Board.toSaveEntity(boardDTO);
        //우리가 호출했던방식으로
        boardRepository.save(board);
    }
    //여기선 DTO객체를 엔티티로 옮겨담았다면,  아래에선, 반대

    public List<BoardDTO> findAll() {
        List<Board> boardEntityList = boardRepository.findAll();
        // 위 코드에선, --List<>만 중요--
        //즉, findall()은 레포지토리로부터 뭔가 가져올땐,  거의 대부분 entity로 온다.
        //즉, 엔티티1개가 아닌, 다수, 여러개를 리스트라고칭하고 리스트,다수엔티티로옴

        //그리고 이 엔티티로 넘어온 객체를 DTO객체로,  옮겨담아 닫시 컨트롤러로
        // 그럼, 리턴할 객체를 선언해주자.먼저

        List<BoardDTO> boardDTOList = new ArrayList<>();
        //즉, 엔티티에 담긴걸-> dto위 코드로 옮겨야지.  작업이필요..
        //작업1) 즉, 엔티티개체를 -> dto객체로 옮겨담는과정이 필요.. 위에선 ↑
        for (Board board : boardEntityList) {
            //반복문으로 접근하는 엔티티객체를 dto로 변환하고.↓
            boardDTOList.add(BoardDTO.toBoardDTO(board));
            //변환된 객체를 boardDTOList에 받는.. for문돌려서.
        }
        return boardDTOList;  //컨트롤러로 리턴.
    }

}
