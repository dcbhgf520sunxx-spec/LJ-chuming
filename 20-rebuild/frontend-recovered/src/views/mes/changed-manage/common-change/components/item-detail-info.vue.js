import { computed as _ } from "vue";
import { ref as y } from "vue";
import { watch as k } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as r } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as n } from "vue";
import { unref as p } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as B } from "vue";
import { ElFormItem as I } from "element-plus";
import { ElForm as N } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { p as x } from "../../../../../modules/common-b3e76e54.js";
import { c as A, a3 as w } from "../../../../../shared/runtime.js";
import { p as C } from "../../../../../modules/mes-ee117a22.js";
import { _ as F } from "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/index-897a9ea4.js";
const W = { __name: "item-detail-info", props: { data: { type: Object }, productType: { type: Number }, showTaskQ: { type: Boolean, default: false }, showSchedulingQ: { type: Boolean, default: false }, showInProductionQ: { type: Boolean, default: false }, showHandleQ: { type: Boolean, default: false } }, setup(e) {
  const s = e, b = _(() => {
    var o;
    return (o = s.data) == null ? void 0 : o.productId;
  }), m = y({}), h = y(false);
  k(() => b.value, () => {
    g();
  }, { immediate: true });
  async function g() {
    try {
      h.value = true;
      const o = await x({ id: s.data.productId, productType: s.productType });
      o.surfaceArea = o.surfaceArea && A(o.surfaceArea, "mm2", "m2"), m.value = Object.assign({}, o, s.data);
    } catch (o) {
      m.value = Object.assign({}, s.data), console.log("获取产品信息", o);
    } finally {
      h.value = false;
    }
  }
  return (o, P) => {
    const f = I, Q = N, u = E, v = T("common-table");
    return i(), S(B, null, [r(Q, { ref: "form", model: e.data, "label-width": "40px", style: { display: "flex" }, "label-position": "left" }, { default: a(() => [r(f, { label: "项目", style: { "margin-right": "20px" } }, { default: a(() => {
      var t;
      return [l("span", null, n((t = e.data.project) == null ? void 0 : t.shortName), 1)];
    }), _: 1 }), r(f, { label: "单体", style: { "margin-right": "20px" } }, { default: a(() => {
      var t;
      return [l("span", null, n((t = e.data.monomer) == null ? void 0 : t.name), 1)];
    }), _: 1 }), r(f, { label: "区域" }, { default: a(() => {
      var t;
      return [l("span", null, n((t = e.data.areaDetail) == null ? void 0 : t.name), 1)];
    }), _: 1 })]), _: 1 }, 8, ["model"]), r(v, { "data-format": p(C)[e.productType], data: [m.value] }, { default: a(() => [e.productType & (p(w).MACHINE_PART.V | p(w).ASSEMBLE.V) ? (i(), d(u, { key: 0, prop: "artifactSerialNumber", "show-overflow-tooltip": true, label: "构件编号", width: "100" }, { default: a(({ row: t }) => [l("span", null, n(t.artifactSerialNumber), 1)]), _: 1 })) : c("", true), r(p(F), { productType: e.productType, unitNewLine: false, unShowField: ["totalNetWeight", "totalGrossWeight", "remark"] }, null, 8, ["productType"]), r(u, { prop: "oldQuantity", "show-overflow-tooltip": true, label: "原清单数量", width: "100", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.oldQuantity), 1)]), _: 1 }), r(u, { prop: "newQuantity", "show-overflow-tooltip": true, label: "变更后清单数量", width: "110", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.newQuantity), 1)]), _: 1 }), e.showTaskQ ? (i(), d(u, { key: 1, prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数量", width: "100", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.taskQuantity), 1)]), _: 1 })) : c("", true), e.showSchedulingQ ? (i(), d(u, { key: 2, prop: "totalSchedulingQuantity", "show-overflow-tooltip": true, label: "排产数量", width: "100", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.totalSchedulingQuantity), 1)]), _: 1 })) : c("", true), e.showInProductionQ ? (i(), d(u, { key: 3, prop: "totalInProductionQuantity", "show-overflow-tooltip": true, label: "已生产数量", width: "100", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.totalInProductionQuantity), 1)]), _: 1 })) : c("", true), e.showHandleQ ? (i(), d(u, { key: 4, prop: "handleQuantity", "show-overflow-tooltip": true, label: "需处理数量", width: "100", align: "center" }, { default: a(({ row: t }) => [l("span", null, n(t.handleQuantity), 1)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data-format", "data"])], 64);
  };
} };
export {
  W as default
};
