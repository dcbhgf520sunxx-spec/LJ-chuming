import { resolveComponent as h } from "vue";
import { openBlock as u } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as d } from "vue";
import { unref as r } from "vue";
import { ElTableColumn as f } from "element-plus";
import { bs as i, D as s, c as _ } from "../../../../../../shared/runtime.js";
const v = { __name: "enclosure", props: { tableData: { type: Array, default: () => [] }, maxHeight: { type: Number, default: void 0 }, isSummary: { type: Boolean, default: false } }, setup(m) {
  return (b, y) => {
    const o = f, c = h("common-table");
    return u(), w(c, { data: m.tableData, "max-height": m.maxHeight, "row-key": "rowId", style: { width: "100%" } }, { default: l(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), m.isSummary ? (u(), w(o, { key: 0, prop: "project", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => {
      var p;
      return [a("span", null, n((p = e.project) == null ? void 0 : p.shortName), 1)];
    }), _: 1 })) : d("", true), t(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": "", label: "单体" }, { default: l((e) => {
      var p;
      return [a("span", null, n((p = e.row.monomer) == null ? void 0 : p.name), 1)];
    }), _: 1 }), t(o, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称" }, { default: l((e) => [a("span", null, n(e.row.name), 1)]), _: 1 }), t(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号" }, { default: l((e) => [a("span", null, n(e.row.serialNumber), 1)]), _: 1 }), t(o, { key: "plate", prop: "plate", "show-overflow-tooltip": "", label: "板型" }, { default: l((e) => [a("span", null, n(e.row.plate), 1)]), _: 1 }), t(o, { key: "color", prop: "color", "show-overflow-tooltip": "", label: "颜色" }, { default: l((e) => [a("span", null, n(e.row.color), 1)]), _: 1 }), t(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: l((e) => [a("span", null, n(e.row.quantity), 1)]), _: 1 }), t(o, { key: "thickness", prop: "thickness", "show-overflow-tooltip": "", label: "厚度(mm)", align: "center" }, { default: l((e) => [a("span", null, n(r(i)(e.row.thickness, r(s).MES_ENCLOSURE_T__MM)), 1)]), _: 1 }), t(o, { key: "width", prop: "width", "show-overflow-tooltip": "", label: "宽度(mm)", align: "center" }, { default: l((e) => [a("span", null, n(r(i)(e.row.width, r(s).MES_ENCLOSURE_W__MM)), 1)]), _: 1 }), t(o, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: l((e) => [a("span", null, n(r(i)(e.row.length, r(s).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(o, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": "", label: "总长度(m)", align: "center" }, { default: l((e) => [a("span", null, n(r(_)(e.row.totalLength, "mm", "m", r(s).MES_ENCLOSURE_L__M)), 1)]), _: 1 }), t(o, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": "", label: "总面积(㎡)", align: "center" }, { default: l((e) => [a("span", null, n(r(_)(e.row.totalArea, "mm2", "m2", r(s).COM_AREA__M2)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  v as default
};
