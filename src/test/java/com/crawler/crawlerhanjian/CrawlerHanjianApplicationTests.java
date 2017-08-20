package com.crawler.crawlerhanjian;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.UrlAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.crawler.constant.HeaderConstant;
import com.crawler.constant.UrlConstant;
import com.crawler.dao.DiseaseDao;
import com.crawler.pojo.Disease;
import com.crawler.pojo.Diseases;
import com.crawler.pojo.Genes;
import com.crawler.pojo.Parents;
import com.crawler.util.ExportExcel;
import com.crawler.util.FileUtil;
import com.crawler.util.HttpClientUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerHanjianApplicationTests {

	public void excel() {
		List<Disease> pojos = new ArrayList<Disease>();
		for (int i = 0; i < 100; i++) {
			Integer param = 1000 + i;
			String params = "{\"key\":\"HP:000" + param.toString() + "\"}";
			try {
				String html = HttpClientUtil.post(
						"https://www.genomcan.cn/search-service/raredisease/search/queryPhenotype",
						HeaderConstant.getHeaderPage(), params);

				// String html =
				// FileUtil.readFileByLines("D:\\work\\workspace\\genomcan.html");
				Disease pojo = JSON.parseObject(html, Disease.class);
				System.out.println("名字" + pojo.getName() + ",参数:" + params);
				pojos.add(pojo);
				System.out.println("获取成功：" + i + "条");
				// dao.save(pojo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// param++;
		}

		ExportExcel.Export(pojos);
	}

	public static void main(String[] args) {

		List<Disease> pojos = new ArrayList<Disease>();
		for (int i = 0; i < 1; i++) {
			Integer param = 0001000;
			try {
				String html = HttpClientUtil.post(
						"https://www.genomcan.cn/search-service/raredisease/search/queryPhenotype",
						HeaderConstant.getHeaderPage(), "HP:" + param.toString());
				System.out.println(html);
				// String html =
				// FileUtil.readFileByLines("D:\\work\\workspace\\genomcan.html");
				Disease pojo = JSON.parseObject(html, Disease.class);
				System.out.println("名字" + pojo.getName());
				pojos.add(pojo);
				param++;
				System.out.println("获取成功：" + i + "条");
				// dao.save(pojo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ExportExcel.Export(pojos);
		/*
		 * String html =
		 * FileUtil.readFileByLines("D:\\work\\workspace\\genomcan.html");
		 * Disease pojo = JSON.parseObject(html, Disease.class);
		 * pojos.add(pojo); pojos.add(pojo); pojos.add(pojo);
		 */

	}

	@Test
	public void contextLoads() {
		try {
			// String params=
			// "{\"key\":\"HP:0001000\",\"limit\":\"20\",\"skip\":\"36\"}";

			String params = "{id: \"HP:0001000\", skip: 56, limit: 20}";
			
			
			
			String html = HttpClientUtil.post(UrlConstant.disList,
					HeaderConstant.genomcan, params);
			System.out.println(html);
			// String html =
			// FileUtil.readFileByLines("D:\\work\\workspace\\genomcan.html");
			// Disease pojo = JSON.parseObject(html, Disease.class);
			// dao.save(pojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
