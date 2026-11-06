import { ref as T } from "vue";
import { computed as H } from "vue";
import { watch as M } from "vue";
import { resolveComponent as W } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as A } from "vue";
import { isRef as O } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as U } from "element-plus";
import { ElTooltip as Q } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { p as Z, a as ee } from "../../../../../modules/machine-part-99f84d79.js";
import { u as te } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { o as ae, J as oe, i as le, L as ne, br as re, bV as ie, D as se } from "../../../../../shared/runtime.js";
import { a as ce } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
const pe = { class: "detail-container" }, ue = { style: { "margin-bottom": "10px" }, class: "tag-div" }, me = { style: { display: "inline-block" } }, de = ["onDblclick"], ke = { __name: "part-detail", props: { currentRow: { type: Object, default: () => {
} }, steelPlateTypeEnum: { type: [String, Number], default: void 0 } }, setup(m) {
  const { showDrawing: d, drawingRow: s, drawingPreview: R } = te({ pidField: "id", productTypeField: "MACHINE_PART" }), o = m, g = T([]), p = T(false), { maxHeight: D } = ae({ extraBox: ".tag-div", paginate: true }), { handleSizeChange: E, handleCurrentChange: N, total: P, setTotalPage: B, queryPage: f } = oe({ fetchHook: w }), _ = H(() => ({ projectId: o.currentRow.projectId, monomerId: o.currentRow.monomerId, areaId: o.currentRow.areaId, areaBatchId: o.currentRow.areaBatchId, thick: o.currentRow.thick, material: o.currentRow.material, steelPlateTypeEnum: o.steelPlateTypeEnum }));
  M(() => _.value, (i) => {
    le(i) && w();
  }, { deep: true, immediate: true });
  async function w() {
    if (g.value = [], !!o.currentRow.projectId) {
      p.value = true;
      try {
        const { content: i = [], totalElements: l } = await Z({ ..._.value, ...f });
        g.value = i, p.value = false, B(l);
      } catch (i) {
        console.log("获取详情失败", i), p.value = false;
      }
    }
  }
  return (i, l) => {
    var y, v, k, I, x;
    const b = G, n = J, z = K, S = U, V = Q, j = W("common-table"), $ = X, q = Y;
    return C(), F("div", pe, [c("div", ue, [e(b, null, { default: a(() => [h(u(`厚度(mm)：${m.currentRow.thick}`), 1)]), _: 1 }), e(b, { style: { "margin-left": "5px" } }, { default: a(() => [h(u(`材质：${m.currentRow.material}`), 1)]), _: 1 }), e(ne, { fn: t(ee), class: "filter-item", params: _.value, style: { "margin-left": "5px" } }, { default: a(() => l[1] || (l[1] = [h(" 零件明细 ")])), _: 1, __: [1] }, 8, ["fn", "params"])]), L((C(), A(j, { data: g.value, "max-height": t(D) }, { default: a(() => [e(n, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), e(n, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { header: a(() => [e(V, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: a(() => [c("div", me, [l[2] || (l[2] = c("span", { style: { "margin-left": "10px" } }, "编号", -1)), e(S, null, { default: a(() => [e(z)]), _: 1 })])]), _: 1 })]), default: a((r) => [e(re, { show: r.row.boolSendDirectly, name: "直发件" }, null, 8, ["show"]), c("span", { style: { cursor: "pointer", "margin-left": "10px" }, onDblclick: (ge) => t(R)(r.row) }, u(r.row.serialNumber), 41, de)]), _: 1 }), e(n, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), e(n, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true }), e(n, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": true }), e(n, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(n, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), e(n, { key: "netWeight", prop: "netWeight", label: "单净重(kg)", align: "center", "show-overflow-tooltip": true }, { default: a((r) => [c("span", null, u(t(ie)(r.row.netWeight, t(se).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[q, p.value]]), e($, { total: t(P), "current-page": t(f).pageNumber, "page-size": t(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(E), onCurrentChange: t(N) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), e(t(ce), { modelValue: t(d), "onUpdate:modelValue": l[0] || (l[0] = (r) => O(d) ? d.value = r : null), "bool-bim": (y = t(s)) == null ? void 0 : y.boolBim, "serial-number": (v = t(s)) == null ? void 0 : v.serialNumber, productId: (k = t(s)) == null ? void 0 : k.productId, productType: (I = t(s)) == null ? void 0 : I.productType, monomerId: (x = t(s)) == null ? void 0 : x.monomerId }, null, 8, ["modelValue", "bool-bim", "serial-number", "productId", "productType", "monomerId"])]);
  };
} };
export {
  ke as default
};
