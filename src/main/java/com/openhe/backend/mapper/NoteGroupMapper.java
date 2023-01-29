package com.openhe.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.openhe.backend.bean.note.NoteGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteGroupMapper extends BaseMapper<NoteGroup> {
    List<NoteGroup> selectAll();
}
