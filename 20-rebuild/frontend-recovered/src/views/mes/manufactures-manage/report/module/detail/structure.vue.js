import { resolveComponent as f } from "vue";
import { openBlock as m } from "vue";
import { createBlock as w } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as h } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as d } from "element-plus";
import { bs as s, D as i } from "../../../../../../shared/runtime.js";
const y = { __name: "structure", props: { tableData: { type: Array, default: () => [] }, maxHeight: { type: Number, default: void 0 }, isSummary: { type: Boolean, default: false } }, setup(u) {
  return (c, g) => {
    const o = d, _ = f("common-table");
    return m(), w(_, { data: u.tableData, "max-height": u.maxHeight, "row-key": "rowId", style: { width: "100%" } }, { default: t(() => [l(o, { label: "序号", type: "index", align: "center", width: "60" }), u.isSummary ? (m(), w(o, { key: 0, prop: "project", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: t(({ row: e }) => {
      var p;
      return [a("span", null, r((p = e.project) == null ? void 0 : p.shortName), 1)];
    }), _: 1 })) : h("", true), l(o, { prop: "monomer.name", "show-overflow-tooltip": "", label: "单体" }, { default: t((e) => {
      var p;
      return [a("span", null, r((p = e.row.monomer) == null ? void 0 : p.name), 1)];
    }), _: 1 }), l(o, { prop: "name", "show-overflow-tooltip": "", label: "名称" }, { default: t((e) => [a("span", null, r(e.row.name), 1)]), _: 1 }), l(o, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号" }, { default: t((e) => [a("span", null, r(e.row.serialNumber), 1)]), _: 1 }), l(o, { prop: "specification", "show-overflow-tooltip": "", label: "规格" }, { default: t((e) => [a("span", null, r(e.row.specification), 1)]), _: 1 }), l(o, { prop: "length", "show-overflow-tooltip": "", label: "长度(mm)" }, { default: t((e) => [a("span", null, r(n(s)(e.row.length, n(i).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), l(o, { prop: "material", "show-overflow-tooltip": "", label: "材质" }, { default: t((e) => [a("span", null, r(e.row.material), 1)]), _: 1 }), l(o, { prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: t((e) => [a("span", null, r(e.row.quantity), 1)]), _: 1 }), l(o, { prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "center" }, { default: t((e) => [a("span", null, r(n(s)(e.row.netWeight, n(i).COM_WT__KG)), 1)]), _: 1 }), l(o, { prop: "grossWeight", "show-overflow-tooltip": "", label: "单毛重(kg)", align: "center" }, { default: t((e) => [a("span", null, r(n(s)(e.row.grossWeight, n(i).COM_WT__KG)), 1)]), _: 1 }), l(o, { prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重(kg)", align: "center" }, { default: t((e) => [a("span", null, r(n(s)(e.row.totalNetWeight, n(i).COM_WT__KG)), 1)]), _: 1 }), l(o, { prop: "totalGrossWeight", "show-overflow-tooltip": "", label: "总毛重(kg)", align: "center" }, { default: t((e) => [a("span", null, r(n(s)(e.row.totalGrossWeight, n(i).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  y as default
};
