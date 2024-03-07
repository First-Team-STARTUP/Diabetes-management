package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.repository.BoardRepository;

import java.util.*;

@Log4j2
@Service //어노테이션붙여줘서 스프링이 관리하는 객체인 빈으로 등록시켜주고~!. ㅋ  조아..  컨트롤러도 안붙이니 스프링이 관리안해서 따로놀더라..
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

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

    // 아침, 점심, 저녁 데이터 가져오는 메서드 추가
//    public Map<String, List<BoardDTO>> findMorningAfternoonEveningData() {
//        Map<String, List<BoardDTO>> dataMap = new HashMap<>();
//
//        // 아침 데이터 가져오기
//        List<BoardDTO> morningData = boardRepository.findByTime("morning")
//                .stream()
//                .map(BoardDTO::toBoardDTO)
//                .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
//                .collect(Collectors.toList());
//        dataMap.put("morning", morningData);
//
//        log.info("morningData" + morningData);
//
//        // morningData에서 afterBlood만 배열로 정리
//        List<Integer> morningDataList = morningData.stream()
//                .map(BoardDTO::getAfterBlood)
//                .collect(Collectors.toList());
//
//        log.info("morningDataList 아침 식후 혈당은 : " + morningDataList);
//
//        // 평균 아침 식후 혈당
//        double averageMorningData = morningDataList.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .orElse(0.0);
//
//        log.info("평균 아침 식후 혈당: " + averageMorningData);
//
//        // 최고 아침 식후 혈당
//        int maxMorningData = morningDataList.stream()
//                .max(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최고 아침 식후 혈당: " + maxMorningData);
//
//        // 최저 아침 식후 혈당
//        int minMorningData = morningDataList.stream()
//                .min(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최저 아침 식후 혈당: " + minMorningData);
//
//
//        // 점심 데이터 가져오기
//        List<BoardDTO> afternoonData = boardRepository.findByTime("afternoon")
//                .stream()
//                .map(BoardDTO::toBoardDTO)
//                .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
//                .collect(Collectors.toList());
//        dataMap.put("afternoon", afternoonData);
//        log.info("afternoonData" + afternoonData);
//
//        // afternoonData에서 afterBlood만 배열로 정리
//        List<Integer> afternoonDataList = afternoonData.stream()
//                .map(BoardDTO::getAfterBlood)
//                .collect(Collectors.toList());
//
//        log.info("afternoonDataList 점심 식후 혈당 : " + afternoonDataList);
//
//        // 평균 아침 식후 혈당
//        double averageAfternoon = morningDataList.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .orElse(0.0);
//
//        log.info("평균 아침 식후 혈당: " + averageAfternoon);
//
//        // 최고 아침 식후 혈당
//        int maxAfternoonData = morningDataList.stream()
//                .max(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최고 아침 식후 혈당: " + maxAfternoonData);
//
//        // 최저 아침 식후 혈당
//        int minAfternoonData = morningDataList.stream()
//                .min(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최저 아침 식후 혈당: " + minAfternoonData);
//
//
//        // 저녁 데이터 가져오기
//        List<BoardDTO> eveningData = boardRepository.findByTime("evening")
//                .stream()
//                .map(BoardDTO::toBoardDTO)
//                .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
//                .collect(Collectors.toList());
//        dataMap.put("evening", eveningData);
//
//        log.info("eveningData" + eveningData);
//
//        // afternoonData에서 afterBlood만 배열로 정리
//        List<Integer> eveningDataList = afternoonData.stream()
//                .map(BoardDTO::getAfterBlood)
//                .collect(Collectors.toList());
//
//        log.info("eveningDataList 저녁 식후 혈당 : " + eveningDataList);
//
//        // 평균 아침 식후 혈당
//        double averageEvening = morningDataList.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .orElse(0.0);
//
//        log.info("평균 저녁 식후 혈당: " + averageEvening);
//
//        // 최고 아침 식후 혈당
//        int maxEveningData = morningDataList.stream()
//                .max(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최고 저녁 식후 혈당: " + maxEveningData);
//
//        // 최저 아침 식후 혈당
//        int minEveningData = morningDataList.stream()
//                .min(Comparator.naturalOrder())
//                .orElse(0);
//
//        log.info("최저 저녁 식후 혈당: " + minEveningData);
//
//        return dataMap;
//    }
}
