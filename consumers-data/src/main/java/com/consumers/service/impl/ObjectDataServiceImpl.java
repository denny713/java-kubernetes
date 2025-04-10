package com.consumers.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.consumers.dto.ObjectDataDto;
import com.consumers.dto.ResultDto;
import com.consumers.model.ObjectData;
import com.consumers.repository.ObjectDataRepository;
import com.consumers.service.ObjectDataService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectDataServiceImpl implements ObjectDataService {
    
    private final ObjectDataRepository objectDataRepository;

    @Override
    @Transactional
    public ResultDto saveObjectData(ObjectDataDto dto) {
        try{
            ObjectData savedData = new ObjectData();
            BeanUtils.copyProperties(dto, savedData);
            
            objectDataRepository.save(savedData);
            return new ResultDto(201,"Success",savedData);
        } catch (Exception e) {
            return new ResultDto(500, "Error", e.getMessage());
        }
    }
}
