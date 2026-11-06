import { ref as i } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as V } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as f } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as R, m as q } from "./module/form.vue.js";
import { x as B, nB as T, o as D, aa as g, P as A } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
import "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
const L = { class: "app-container" }, M = { class: "tc-primary" }, W = { class: "tc-primary" }, G = { __name: "index", setup(F) {
  const y = { add: false, edit: false, del: false, download: false }, b = i([["startTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), c = i(), d = i({}), n = i(false), { crud: o } = B({ title: "焊接数据采集记录", sort: [], permission: { ...T }, optShow: { ...y }, requiredQuery: ["areaId"], crudApi: { ...R } }, c), { maxHeight: _ } = D({ paginate: true });
  function x(m) {
    d.value = m, n.value = true;
  }
  return (m, u) => {
    const t = E, v = C("common-table"), k = P;
    return s(), N("div", L, [e(a(U)), S((s(), w(v, { ref_key: "tableRef", ref: c, data: a(o).data, "empty-text": a(o).emptyText, "max-height": a(_), "data-format": b.value, "row-class-name": "pointer", onRowClick: x }, { default: l(() => {
      var r;
      return [e(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(t, { key: "productSerialNumber", prop: "productSerialNumber", label: `${(r = a(g).VL) == null ? void 0 : r[a(o).query.productType]}编号`, align: "center", "min-width": "100px", "show-overflow-tooltip": "" }, null, 8, ["label"]), a(o).query.productType === a(g).ASSEMBLY.V ? (s(), w(t, { key: "productName", prop: "productName", label: "部件名称", align: "center", "min-width": "110px", "show-overflow-tooltip": "" })) : V("", true), e(t, { key: "weldingSerialNumber", prop: "weldingSerialNumber", label: "焊缝编号", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "techCappCraftCardStorehouseSerialNumber", prop: "techCappCraftCardStorehouseSerialNumber", label: "工艺编号", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "weldingBaseWeldingPosition", prop: "weldingBaseWeldingPosition", align: "center", label: "焊接位置", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "weldingCraftParameterPass", prop: "weldingCraftParameterPass", align: "center", label: "道次", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "equimentName", prop: "equimentName", align: "center", label: "设备名称", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "equimentCode", prop: "equimentCode", align: "center", label: "设备编号", width: "160px", "show-overflow-tooltip": "" }), e(t, { key: "weldUserName", prop: "weldUserName", align: "center", label: "实际焊接人", "min-width": "100px", "show-overflow-tooltip": "" }), e(t, { key: "startTime", prop: "startTime", align: "center", label: "开始时间", width: "150px", "show-overflow-tooltip": "" }), e(t, { label: "电流(A)", align: "center" }, { default: l(() => [e(t, { key: "ratedElectricity", prop: "ratedElectricity", align: "center", label: "额定", width: "100px", "show-overflow-tooltip": "" }), e(t, { key: "actualElectricity", prop: "actualElectricity", align: "center", label: "实际", width: "100px", "show-overflow-tooltip": "" }, { default: l(({ row: p }) => [h("span", M, f(p.actualElectricity), 1)]), _: 1 })]), _: 1 }), e(t, { label: "电压(V)", align: "center" }, { default: l(() => [e(t, { key: "ratedVoltage", prop: "ratedVoltage", align: "center", label: "额定", width: "100px", "show-overflow-tooltip": "" }), e(t, { key: "actualVoltage", prop: "actualVoltage", align: "center", label: "实际", width: "100px", "show-overflow-tooltip": "" }, { default: l(({ row: p }) => [h("span", W, f(p.actualVoltage), 1)]), _: 1 })]), _: 1 })];
    }), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[k, a(o).loading]]), e(a(A)), e(a(q), { modelValue: n.value, "onUpdate:modelValue": u[0] || (u[0] = (r) => n.value = r), detailRow: d.value, onSuccess: a(o).refresh }, null, 8, ["modelValue", "detailRow", "onSuccess"])]);
  };
} };
export {
  G as default
};
