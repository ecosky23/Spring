package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {

	public MemberDTO login(Map<String, String> map);

	public MemberDTO checkId(String id);

	public List<ZipcodeDTO> getZipecodeList(Map<String, String> map);

	

}
