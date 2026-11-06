import { ref as m } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as o } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as S } from "vue";
import { createTextVNode as N } from "vue";
import { ElTableColumn as k } from "element-plus";
import { ElTag as T } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as E } from "./module/preview.vue.js";
import { C as L } from "../../../../../modules/plan-d12d7ccf.js";
import { oG as M, x as V, o as q, aa as h, P as B } from "../../../../../shared/runtime.js";
import R from "./module/header.vue.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "./module/bind.vue.js";
import "../../../../../modules/craft-library-fde84566.js";
const A = { class: "app-container" }, P = { key: 0 }, X = { __name: "index", setup(H) {
  const w = { add: false, edit: false, del: false, download: false }, b = m([["craftType", ["parse-enum", M]]]), c = m(), { crud: p, columns: a } = V({ title: "工艺管理", sort: [], permission: { ...L }, optShow: { ...w }, requiredQuery: ["areaId"], crudApi: { ...E } }, c), { maxHeight: g } = q({ paginate: true });
  return ($, s) => {
    const r = k, y = T, _ = v("common-table"), C = D;
    return t(), f("div", A, [l(e(R)), x((t(), o(_, { ref_key: "tableRef", ref: c, data: e(p).data, "empty-text": e(p).emptyText, "max-height": e(g), "data-format": b.value }, { default: n(() => {
      var d;
      return [l(r, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(a).visible("weldSerialNumber") ? (t(), o(r, { key: "weldSerialNumber", prop: "weldSerialNumber", label: "焊缝编号", align: "center", "min-width": "100px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("productName") && e(p).query.productType === e(h).ASSEMBLY.V ? (t(), o(r, { key: "productName", prop: "productName", label: "部件名称", align: "center", "min-width": "110px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("productSerialNumber") ? (t(), o(r, { key: "productSerialNumber", prop: "productSerialNumber", label: `${(d = e(h).VL) == null ? void 0 : d[e(p).query.productType]}编号`, align: "center", "min-width": "100px", "show-overflow-tooltip": "" }, null, 8, ["label"])) : i("", true), e(a).visible("productSpecification") ? (t(), o(r, { key: "productSpecification", prop: "productSpecification", label: "规格", align: "center", "min-width": "140px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("productLength") ? (t(), o(r, { key: "productLength", prop: "productLength", label: "长度(mm)", align: "center", width: "120px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("productMaterial") ? (t(), o(r, { key: "productMaterial", prop: "productMaterial", label: "材质", align: "center", width: "100px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("weldCount") ? (t(), o(r, { key: "weldCount", prop: "weldCount", label: "焊缝数量", align: "center", width: "80px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("productDwgNum") ? (t(), o(r, { key: "productDwgNum", prop: "productDwgNum", label: "图号", align: "center", "min-width": "160px", "show-overflow-tooltip": "" })) : i("", true), e(a).visible("techCappCraftCardStorehouseSerialNumber") ? (t(), o(r, { key: "techCappCraftCardStorehouseSerialNumber", prop: "techCappCraftCardStorehouseSerialNumber", label: "工艺编号", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }, { default: n(({ row: u }) => [u.sourceRow.techCappCraftCardStorehouseSerialNumber ? (t(), f("span", P, S(u.techCappCraftCardStorehouseSerialNumber), 1)) : (t(), o(y, { key: 1, effect: "plain", type: "danger" }, { default: n(() => s[0] || (s[0] = [N("暂无绑定")])), _: 1, __: [0] }))]), _: 1 })) : i("", true), e(a).visible("craftType") ? (t(), o(r, { key: "craftType", prop: "craftType", label: "工艺类型", align: "center", width: "100px", "show-overflow-tooltip": "" })) : i("", true)];
    }), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[C, e(p).loading]]), l(e(B))]);
  };
} };
export {
  X as default
};
