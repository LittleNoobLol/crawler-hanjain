package com.crawler.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

//下面是和数据导出有关的包
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.crawler.pojo.Disease;
import com.crawler.pojo.Diseases;
import com.crawler.pojo.Genes;
import com.crawler.pojo.Parents;

public class ExportExcel {
	public static void Export(List<Disease> list) {
		// 声明一个工作薄
		HSSFWorkbook wb = new HSSFWorkbook();
		// 声明一个单子并命名
		HSSFSheet sheet = wb.createSheet("数据");
		// 给单子名称一个长度
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle style = wb.createCellStyle();
		// 创建第一行（也可以称为表头）
		HSSFRow row = sheet.createRow(0);
		// 样式字体居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 给表头第一行一次创建单元格
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("中文名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("英文名");
		cell = row.createCell((short) 3);
		cell.setCellValue("英文定义");
		cell = row.createCell((short) 4);
		cell.setCellValue("中文定义");
		cell = row.createCell((short) 5);
		cell.setCellValue("所属系统（英文）");
		cell = row.createCell((short) 6);
		cell.setCellValue("所属系统（中文）");
		cell = row.createCell((short) 7);
		cell.setCellValue("相关疾病总数");
		cell = row.createCell((short) 8);
		cell.setCellValue("编号（相关疾病）");
		cell = row.createCell((short) 9);
		cell.setCellValue("英文（相关疾病）");
		cell = row.createCell((short) 10);
		cell.setCellValue("中文（相关疾病）");
		cell = row.createCell((short) 11);
		cell.setCellValue("关联基因（相关疾病）");
		cell = row.createCell((short) 12);
		cell.setCellValue("编号（上级节点）");
		cell = row.createCell((short) 13);
		cell.setCellValue("英文（上级节点）");
		cell = row.createCell((short) 14);
		cell.setCellValue("中文翻译（上级节点）");
		cell = row.createCell((short) 15);
		cell.setCellValue("相关基因总数");
		cell = row.createCell((short) 16);
		cell.setCellValue("基因（相关基因）");
		cell = row.createCell((short) 17);
		cell.setCellValue("相关疾病(英文)（相关基因）");
		cell = row.createCell((short) 18);
		cell.setCellValue("相关疾病(中文)（相关基因）");
		cell.setCellStyle(style);

		// 当前行
		int rows = 0;
		// 下一次最大行
		int rowsCount = 0;
		
		// 向单元格里填充数据
		for (short i = 0; i < list.size(); i++) {
			rows++;
			row = sheet.createRow(rows);
			Disease info = list.get(i);
			row.createCell(0).setCellValue(info.getId());
			row.createCell(1).setCellValue(info.getName());
			row.createCell(2).setCellValue(info.getEname());
			row.createCell(3).setCellValue(info.getEdef());
			row.createCell(4).setCellValue(info.getZhdef());
			row.createCell(5).setCellValue(info.getEcategory());
			row.createCell(6).setCellValue(info.getZhcategory());
			row.createCell(7).setCellValue(info.getDtotal());
			//相关基因总数
			row.createCell(15).setCellValue(info.getGtotal());

			// 获取上级节点信息
			List<Parents> parents = info.getParents();
			// 获取相关疾病
			List<Diseases> diseases = info.getDiseases();
			// 获取相关基因
			List<Genes> genes = info.getGenes();
			// 上级节点和相关疾病取最大值，确保row行
			rowsCount = parents.size() > diseases.size() ? parents.size() : diseases.size();
			int gens = 0;
			
			List<Diseases> MyGenes=new ArrayList<Diseases>();
			
			// 比较相关基因下的子节点
			for (Genes gen : genes) {
				gens = gens > gen.getDiseases().size() ? gens : gen.getDiseases().size();
				List<Diseases> dis = gen.getDiseases();
				
				for (Diseases di : dis) {
					di.setSymbol(gen.getSymbol());
				}
				MyGenes.addAll(gen.getDiseases());
				
			}
			
			// 上级节点和相关疾病和相关基因比较
			rowsCount = gens > rowsCount ? gens : rowsCount;

			for (int j = 0; j < rowsCount; j++) {
				if (j > 0) {
					row = sheet.createRow(++rows);
				}
				
				// 相关疾病写入
				if (j<diseases.size()) {
					Diseases infos = diseases.get(j);
					row.createCell(8).setCellValue(infos.getId());
					row.createCell(9).setCellValue(infos.getEname());
					row.createCell(10).setCellValue(infos.getName());
					row.createCell(11).setCellValue(infos.getGenes());
				}
				
				// 上级节点
				if (j<parents.size()) {
					Parents pinfo = parents.get(j);
					row.createCell(12).setCellValue(pinfo.getId());
					row.createCell(13).setCellValue(pinfo.getEname());
					row.createCell(14).setCellValue(pinfo.getZhname());
				}

				if (j<MyGenes.size()) {
					Diseases dis = MyGenes.get(j);
					row.createCell(16).setCellValue(dis.getSymbol());
					row.createCell(17).setCellValue(dis.getEname());
					row.createCell(18).setCellValue(dis.getName());
				}

			}
			/*
			 * int drows = rows; for (int j = 0; j < diseases.size(); j++) {
			 * HSSFRow drow = sheet.createRow(rows); if (j > 0) { ++drows; drow
			 * = sheet.createRow(drows); } Diseases infos = diseases.get(j);
			 * System.out.println("火狐" + infos.getEname());
			 * drow.createCell(8).setCellValue(infos.getId());
			 * drow.createCell(9).setCellValue(infos.getEname());
			 * drow.createCell(10).setCellValue(infos.getName());
			 * drow.createCell(11).setCellValue(infos.getGenes()); } int prows =
			 * rows; for (int j = 0; j < parents.size(); j++) { HSSFRow prow =
			 * sheet.createRow(rows); if (j > 0) { prows++; prow =
			 * sheet.createRow(prows); } Parents pinfo = parents.get(j);
			 * prow.createCell(12).setCellValue(pinfo.getId());
			 * prow.createCell(13).setCellValue(pinfo.getEname());
			 * prow.createCell(14).setCellValue(pinfo.getZhname()); }
			 */
			//rows += rowsCount;
		}

		try

		{
			// 默认导出到E盘下
			FileOutputStream out = new FileOutputStream("D:\\work\\workspace\\test.xls");
			wb.write(out);
			out.close();
			//JOptionPane.showMessageDialog(null, " 导出成功!");
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "导出失败!");
			e.printStackTrace();
		} catch (IOException e) {
			//JOptionPane.showMessageDialog(null, " 导出失败!");
			e.printStackTrace();
		}
	}
}
