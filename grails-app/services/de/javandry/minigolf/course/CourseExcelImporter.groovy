package de.javandry.minigolf.course

import org.grails.plugins.excelimport.AbstractExcelImporter
import org.grails.plugins.excelimport.ExcelImportService

class CourseExcelImporter extends AbstractExcelImporter {

    static Map CONFIG_COLUMN_MAP = [
            sheet: 'Tabelle1',
            startRow: 4,
            columnMap: [
                    'D': 'number',
                    'H': 'federation',
                    'I': 'zip',
                    'J': 'city',
                    'K': 'street',
                    'L': 'phone',
                    'M': 'club',
                    'N': 'system',
                    'O': 'indoor',
            ]
    ]

    def excelImportService

    public CourseExcelImporter() {
        excelImportService = ExcelImportService.getService()
    }

    List<Map> getCourses() {
        excelImportService.columns(workbook, CONFIG_COLUMN_MAP)
    }
}
