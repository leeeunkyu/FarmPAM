package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UtilExcel {
	/**UtilExcel 객체를 얻기위한 instance변수 */
	private static UtilExcel instance = new UtilExcel();
	
	private UtilExcel() {	}
	
	public static UtilExcel getInstance() {
		return instance;
	}
	/**
	 * 농수산 정보 엑셀파일을 읽어서 디비에 저장하기 위한 메소드
	 * a열 조사 구분코드 examinCd
	 * b열 조사 지역명 areaName
	 * c열 조사 품목코드 prdlstCd
	 * d열 조사 품목명 prdlstName
	 * db에 들어갈 값 조사 구분 코드,조사 지역명,조사 품목코드,조사 품목명
	 * @return
	 */
	public HashMap<String, String> loadFarmInfo(){
		/**HashMap
		 * key 리스트
		 * 조사 구분코드 examinCd+[index]
		 * 조사 지역명 areaName+[index]
		 * 조사 품목코드 prdlstCd+[index]
		 * 조사 품목명 prdlstName+[index]
		 *  */
		HashMap<String, String> farmlist = new HashMap<>();
		try {
			FileInputStream fis=new FileInputStream("src/conf/farminfo_mini.xls");
			System.out.println("성공적으로 엑셀 파일을 읽었음.");
			HSSFWorkbook workbook=new HSSFWorkbook(fis);
			int rowindex=0;
			int columnindex=0;
			//시트 수 (첫번째에만 존재하므로 0을 준다)
			//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			HSSFSheet sheet=workbook.getSheetAt(0);
			//행의 수
			int rows=sheet.getPhysicalNumberOfRows();
			System.out.println(rows);//3862
			for(rowindex=1;rowindex<rows;rowindex++){
			    //행을 읽는다
			    HSSFRow row=sheet.getRow(rowindex);
			    if(row !=null){
			        //셀의 수
			        int cells=row.getPhysicalNumberOfCells();
			        for(columnindex=0;columnindex<=cells;columnindex++){
			            //셀값을 읽는다
			            HSSFCell cell=row.getCell(columnindex);
			            String value="";
			            //셀이 빈값일경우를 위한 널체크
			            if(cell==null){
			                continue;
			            }else{
			                //타입별로 내용 읽기
			                switch (cell.getCellType()){
			                case HSSFCell.CELL_TYPE_FORMULA:
			                    value=cell.getCellFormula();
			                    break;
			                case HSSFCell.CELL_TYPE_NUMERIC:
			                    value=cell.getNumericCellValue()+"";
			                    break;
			                case HSSFCell.CELL_TYPE_STRING:
			                    value=cell.getStringCellValue()+"";
			                    break;
			                case HSSFCell.CELL_TYPE_BLANK:
			                    value=cell.getBooleanCellValue()+"";
			                    break;
			                case HSSFCell.CELL_TYPE_ERROR:
			                    value=cell.getErrorCellValue()+"";
			                    break;
			                }
			            }
			            	switch (columnindex) {
							case 0:
								farmlist.put("examinCd["+rowindex+"]", value);
								break;
							case 1:
								farmlist.put("areaName["+rowindex+"]", value);
								break;
							case 2:
								farmlist.put("prdlstCd["+rowindex+"]", value);
								break;
							case 3:
								farmlist.put("prdlstName["+rowindex+"]", value);		
								break;
								

							default:
								break;
							}
			            }
			        }
			    /* 조사 구분코드 examinCd+[index]
			   		 * 조사 지역명 areaName+[index]
			   		 * 조사 품목코드 prdlstCd+[index]
			   		 * 조사 품목명 prdlstName+[index]
			    */
			    System.out.println("examinCd["+rowindex+"] = "+farmlist.get("examinCd["+rowindex+"]")
			    +"  areaName["+rowindex+"] = "+farmlist.get("areaName["+rowindex+"]")
			    +"  prdlstCd["+rowindex+"] = "+farmlist.get("prdlstCd["+rowindex+"]")
			    +"  prdlstName["+rowindex+"] = "+farmlist.get("prdlstName["+rowindex+"]"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return farmlist;
	}
}
