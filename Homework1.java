package homework;
/*
//"select ename salary, from employee"
 �Aconsole�L�X:
 
select
employee
ename
salary
*/
 
import java.util.ArrayList;
import java.util.List;

public class Homework1 {

	public static void main(String[] args) {

		String str = "seleCT EnAmE sAlArY, from, employee  ";   //�N�r��"sele..."��Jstr�o�ӫ��A��String�ܼ�
		String str1[] = str.split(",| ");                   //�N�r��"sele..."��", "�M" "�Ӥ���(split)�b�ᤩ�����A��String���}�C str1
		
//		for(String ss : str1) {                              //���j��O���F�n�ݤ��Ϋ᪺���G                              
//			System.out.print(ss);                            //�p�G�S���ϥ� �h�|�L�X [Ljava.lang.String;@4101f2ae
//		}
		
		List<String> liststr = new ArrayList<>();      //new�@��ArrayList������
		
		for (String str2 : str1) {                           //5.0��for�j��   �_��(:)�᭱��n�B�z������ �A�N������J ���A��String���ܼ�str2 �U��h�s�g�n�p��B�z
			if (!str2.isEmpty()) {                           //if() ��Jstr2�������� �p�G�P�_���O�ť�   
				liststr.add(str2.toLowerCase());             //�h��liststr����I�sadd��k �s�W�� str2 (�A��toLowerCase�����ন�p�g)
			}                                         
		}                                                    //���H�W�j��ΨӳB�z�p�G�r�ꤤ�[�J�\�h���ťոӫ��B�z��
		System.out.println("�z��L�᪺�����é�Jliststr��:" + liststr);
		for (int x = 0; x < liststr.size(); x++) {           //for�j��...�������� liststr�������Ӽ� size()�^�Ǥ��������Ӽ�
			if (liststr.get(x).equals("employee")) {         //xxx.get(n) ����k�O���^�ǲ�n�Ӥ��� �p�G�^�ǲ�n�Ӥ��� (equals��k�O�P�_�O�_�ۦP) �M"employee"�ۦP 
				liststr.add(1, liststr.get(x));              //�h�N�o�Ӥ����[�J(��k�Oadd)��liststr�� ���Ь�"1" (�]�N�O�ĤG��) 
				break;                                       //�Nemployee�ܦ���2�Ӥ��� �N����o�Ӱj�� 
			}
		}
		System.out.println("�Nemployee���e������(��employee����):" + liststr);
		
		int n = liststr.size();                              //��X�`�@���X�Ӥ���
		liststr.remove(n - 1);                               //�o���remove�O���F�u�O�d�ŦX�D�حn��
		liststr.remove(n - 2);                               //���p�G�b�᭱�h�[�F��L���r�Ψ�L�Ÿ� �h�L�k�ŦX�D�حn����
		for (String str3 : liststr)                          //�A�Nliststr�����F�� �@�Ӥ@�ӵ�str3 
			System.out.println(str3);                        //�A�L�X�ӡC
	}

}
