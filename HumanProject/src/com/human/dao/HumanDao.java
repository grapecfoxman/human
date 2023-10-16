package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.human.dto.HumanDto;
import com.human.util.DBConn;

//ctr+a 모든 코드 선택 ctr+shift+f 코드정리
public class HumanDao {
	//1. 디비를 이용해서 데이터 관리를 하므로 더이상 필요없음
	//private ArrayList<HumanDto> dtos = new ArrayList<HumanDto>();

	//2. 데이터 초기화 init
	public void init() {
		//1번데이터
		HumanDto dto=new HumanDto("홍길동", 30, 152.1,
				LocalDateTime.parse("2000-02-03 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		//to_date('%s', 'YYYY:MM:DD HH24:MI:SS'))
		String sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				//,"2000-02-03 00:00:00");
		DBConn.statementUpdate(sql);
		
		//2번데이터
		dto=new HumanDto("홍길동", 31, 156.4,
				LocalDateTime.parse("2000-02-03 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);
		
		//3번데이터
		dto=new HumanDto("홍길영", 33, 173.5,
				LocalDateTime.parse("2000-12-21 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);		
	}
	//3.insert작업
	public void insert(HumanDto dto) {
		String sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);	
	}
	//4. update작업
	public void update(String name,int age) {
		//update  이름을 이용해서 나이를 변경하는 형태
		DBConn.statementUpdate(String.format(
				"update human set age=%d where name='%s'",age,name));
	}
	//5. delete작업
	public void delete(int age) {
		DBConn.statementUpdate(String.format("delete human where age < %d", age));
	}
	//6. select 작업
	public  ArrayList<HumanDto> select() {
		ArrayList<HumanDto> resultDtos=new ArrayList<HumanDto>();

		ResultSet rs=DBConn.statementQuery(
				String.format("select * from human"));
		
		try {
			while(rs.next()) {
				resultDtos.add(new HumanDto(
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime()));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultDtos;
	}
	public ArrayList<HumanDto> select(double height) {
		//키가 155이상인 사람 출력
		ArrayList<HumanDto> resultDtos=new ArrayList<HumanDto>();

		ResultSet rs=DBConn.statementQuery(
				String.format("select * from human where height>%d",height));
		
		try {
			while(rs.next()) {
				resultDtos.add(new HumanDto(
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime()));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDtos;
	}
}








