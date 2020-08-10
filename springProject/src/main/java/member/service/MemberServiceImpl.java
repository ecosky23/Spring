package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO login(Map<String, String> map) {
		
		
		MemberDTO memberDTO = memberDAO.login(map);
		 
		 return memberDTO;
		
	}

	@Override
	public String checkId(String id) {
		
		MemberDTO memberDTO = memberDAO.checkId(id);
		if(memberDTO == null) {
			return "non_exist";//사용가능
		}else {
			return "exist";//아이디존재 사용불가능
		}
		
		
	}

	@Override
	public List<ZipcodeDTO> getZipecodeList(Map<String, String> map) {
		
		return memberDAO.getZipecodeList(map);
	}

	@Override
	public void write(MemberDTO memberDTO) {
		
		memberDAO.write(memberDTO);
		
	}

	@Override
	public MemberDTO getMember(String id) {
		
		return memberDAO.checkId(id);
	}

	@Override
	public void modify(MemberDTO memberDTO) {
		memberDAO.modify(memberDTO);
		
	}

	
	

}
