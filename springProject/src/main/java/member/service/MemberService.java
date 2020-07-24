package member.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
@Service
public interface MemberService {

	public MemberDTO login(Map<String, String> map);

	public String checkId(String id);

	public List<ZipcodeDTO> getZipecodeList(Map<String, String> map);

	

}
