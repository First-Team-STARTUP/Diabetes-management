package org.startup.diabetes.service;

import org.startup.diabetes.domain.GraphVO;

import java.util.List;

public interface GraphService {
    public List<GraphVO> countFasting(GraphVO vo) throws Exception;
}
