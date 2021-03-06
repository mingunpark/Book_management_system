package library_M;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManage {
	
	private UserList user=new UserList();
	private Scanner sc=new Scanner(System.in);
	private String name=null,id=null,phNum=null,mail=null;
	private String passwrd;
	private final int NEWSPACE = 80;
	private Console console=System.console();
	
	public String getUser(){
		return id;
	}
	public String getPass(){
		return passwrd;
	}
	
	public UserList signUp(ArrayList<UserList> member){
		
		
		UserList temp = null;
		do{
			try{
				
				System.out.println("==========회원가입==========");
				System.out.println("이름 입력(2-10자 이내의 한글) : ");
				name=sc.next();
				System.out.println("아이디 입력(4-16자 이내) : ");
				id=sc.next();
				System.out.println("비밀번호 입력(8-16자 이내) : ");
				passwrd=sc.next();
				System.out.println("전화번호 입력(형식 => 010-####-####) : ");
				phNum=sc.next();
				System.out.println("이메일 입력(형식 => gusdn0563@naver.com) : ");
				mail=sc.next();
				
				if(name.length()>=2 && name.length()<=10 && id.length()>=4 && id.length()<=16
						&& passwrd.length()>=8 && passwrd.length()<=16 && phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})")
						&& mail.contains("@"))
				{
					for(UserList u : member){
						if(u.getID().compareTo(id)==0){
							
							System.out.println("이미 존재하는 아이디 입니다!");
							temp=u;
							throw new Exception();
						}
					}
							
					System.out.println("회원 가입 완료.");
					try{ Thread.sleep(1000);}
					catch(Exception e){e.printStackTrace();}

										
					break;
					
				}else
					throw new Exception();
				
					
			}catch(Exception e){
				for(int i=0;i<3;i++)
					System.out.println("");
			
					
				if(name.length()<2 || name.length()>10){
					System.out.println("[ 이 름 ]");
				}
				if(id.length()<4 ||  id.length()>16){
					System.out.println("[ 아 이 디 ]");
				}
				if(passwrd.length()<8 || passwrd.length()>16){
					System.out.println("[ 비 밀 번 호 ]");
				}
				if(!(phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})"))){
					System.out.println("[ 휴대폰 번호 ]");
				}
				if(!mail.contains("@")){
					System.out.println("[ 이 메 일 ]");
				}
				System.out.println("양식에 맞게 입력해주시기 바랍니다.");
				
			}
		}while(true);
		
		user.setMail(mail);
		user.setName(name);
		user.setPass(passwrd);
		user.setPhone(phNum);
		user.setId(id);

		return user;
		
	}
	
	
	public boolean signIn(ArrayList<UserList> member){
		
		int count=0;
		int success=0;
		
		do{
			try{
				System.out.println("==========로그인==========");
				
				System.out.println("아이디 : ");
				id=sc.next();
				System.out.println("비밀번호 : ");
				passwrd = sc.next();
				
				for(UserList i : member){
					if(i.getID().compareTo(id)==0 && i.getPass().compareTo(passwrd)==0)
					{
						System.out.println("로그인에 성공하셨습니다.");
						try{ Thread.sleep(1000);}
						catch(Exception e){e.printStackTrace();}
						success=1;
						break;
						
					}
				}
				if(success==1)
					break;
				else
					throw new Exception();

				
			}catch(Exception e){
				count++;
				
				if(count==3){
					System.out.println("로그인 3회로 인해 프로그램 종료!");
					System.exit(0);
				}
				System.out.println("");
				System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
				System.out.println("3회 틀릴 시 프로그램은 종료됩니다. ["+count+"/3]" );
				System.out.println("");	
			}
		}while(true);
		
		return true;
		
	}
	
	public boolean isCorrectSignUpFormat(String name, String id, String paswrd, String phNum, String mail){
		return name.length()>=2 && name.length()<=10 && id.length()>=4 && id.length()<=16
				&& passwrd.length()>=8 && passwrd.length()<=16 && phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})")
				&& mail.contains("@");
	}
	public void editUserInfo(ArrayList<UserList> userList){
		
		UserList user=new UserList();
		UserList temp=new UserList();
		String name=null,id=null,phNum=null,mail=null;
		String passwrd;
		String pasCheck1;
		int i=0;
		
		MainClass main=new MainClass();
		
		
		for(int j=0;j<userList.size();j++)
		{
			if(userList.get(j).getID().compareTo(main.getUser())==0){
				i=j;
				break;
			}			
		}
		
		System.out.print("비밀번호 입력 : ");
		pasCheck1=sc.next();
		
		if(userList.get(i).getPass().compareTo(pasCheck1)==0){
			
			do{
				try{
					System.out.println("================회원 정보 수정================");
					System.out.println("이름 입력(기존 : "+userList.get(i).getName()+" ) : ");
					name=sc.next();
					System.out.println("비밀번호 입력(8-16자 이내) : ");
					passwrd=sc.next();
					System.out.println("전화번호 입력(기존 : "+userList.get(i).getPhone()+" ) : ");
					phNum=sc.next();
					System.out.println("이메일 입력(기존 : "+userList.get(i).getMail()+" ) : ");
					mail=sc.next();
					
					// isCorrectSignUpFormat()
					// 회원가입을 할때 정해진 포맷에 맞는지 확인
					/*
					if(name.length()>=2 && name.length()<=10 && id.length()>=4 && id.length()<=16
							&& passwrd.length()>=8 && passwrd.length()<=16 && phNum.matches("01[016789]-(\\d{3,4})-(\\d{4})")
							&& mail.contains("@"))
					*/
					if(isCorrectSignUpFormat(name, id, passwrd, phNum, mail))
					{
						for(UserList u : userList){
							if(u.getID().compareTo(id)==0){
								System.out.println("이미 존재하는 아이디 입니다!");
								throw new Exception();
							}
						}
								
						System.out.println("회원 가입 완료.");
						try{ Thread.sleep(1000);}
						catch(Exception e){e.printStackTrace();}

											
						break;
						
					}else
						throw new Exception();
					
				}catch(Exception e)
				{
					
				}
				
			}while(true);
			userList.get(i).setName(name);
			userList.get(i).setPass(passwrd);
			userList.get(i).setPhone(phNum);
			userList.get(i).setMail(mail);
		}else{
			System.out.println("비밀번호가 올바르지 않습니다!");
			System.out.println("계속 진행하시려면 Enter키를 눌러주시기 바랍니다.");
			ManageBook.pause();
		}
	
		
	}
	
	public void deleteUser(ArrayList<UserList> userList){
		
		int i=0;
		MainClass main=new MainClass();
		
		for(int j=0;j<userList.size();j++)
		{
			if(userList.get(j).getID().compareTo(main.getUser())==0){
				i=j;
				break;
			}			
		}
		
		
		System.out.println(userList.get(i).getID()+" | "+main.getUser() );
		
		userList.remove(i);
	}
	




}
