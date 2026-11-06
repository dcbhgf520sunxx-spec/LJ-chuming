import { computed as w } from "vue";
import { ref as v } from "vue";
import { watch as L } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as d } from "vue";
import { withCtx as f } from "vue";
import { unref as e } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as y } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as C } from "vue";
import { ElTag as _ } from "element-plus";
import { aa as l, ms as k, B as j, oW as N, t8 as D, E as O, t3 as U, t5 as B, t0 as H, t6 as A } from "../../../../../../shared/runtime.js";
import Q from "../../../../../supply-chain/components/audit-records.vue.js";
const z = { __name: "header", props: { globalProject: { type: Object, default: () => {
} }, APPtotal: { type: [String, Number], default: void 0 }, subTotal: { type: [String, Number], default: void 0 }, rejTotal: { type: [String, Number], default: 0 } }, setup(V) {
  const E = w(() => t.productType === l.ASSEMBLY.V ? "NC1" : "DXF"), m = V, P = { dataType: k.NC_DRAWING.V, productType: l.ASSEMBLY.V, steelPlateTypeEnum: void 0, monomerId: void 0, areaId: void 0 }, { crud: s, query: t } = j(P), i = v(false), o = v({});
  function I(u) {
    const a = u;
    o.value.moduleType = B.PLAN_MANAGEMENT.V, o.value.componentNameList = [H.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V], a === 1 ? (o.value.reviewStatus = A.WITHDRAW.V, o.value.waitMeCheck = true, o.value.meLaunch = false) : a === 2 ? (o.value.reviewStatus = A.WITHDRAW.V, o.value.waitMeCheck = false, o.value.meLaunch = true) : a === 3 && (o.value.reviewStatus = A.REJECT.V, o.value.waitMeCheck = false, o.value.meLaunch = false), i.value = true;
  }
  return L(() => t.productType, () => {
    t.productType !== l.MACHINE_PART.V && (t.steelPlateTypeEnum = void 0);
  }), (u, a) => {
    const g = c("common-radio-button"), M = c("monomer-select"), h = c("common-select"), b = _;
    return p(), R("div", null, [d(e(O), null, { optLeft: f(() => {
      var r;
      return [d(g, { modelValue: e(t).productType, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(t).productType = n), options: e(l).ENUM, unshowVal: [e(l).ARTIFACT.V], type: "enum", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), e(t).productType === e(l).MACHINE_PART.V ? (p(), T(g, { key: 0, modelValue: e(t).steelPlateTypeEnum, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(t).steelPlateTypeEnum = n), options: e(N).ENUM, unshowVal: [e(N).SECTION_STEEL.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : y("", true), e(t).productType === e(l).MACHINE_PART.V ? (p(), T(M, { key: 1, modelValue: e(t).monomerId, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(t).monomerId = n), clearable: "", "project-id": (r = V.globalProject) == null ? void 0 : r.id, class: "filter-item", placeholder: "选择单体筛选", default: false, onGetAreaInfo: u.getAreaInfo, onChange: e(s).toQuery }, null, 8, ["modelValue", "project-id", "onGetAreaInfo", "onChange"])) : y("", true), e(t).productType === e(l).MACHINE_PART.V && u.drawingMatchRange && u.drawingMatchRange === e(D).AREA.V ? (p(), T(h, { key: 2, modelValue: e(t).areaId, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(t).areaId = n), options: u.areaList, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", class: "filter-item", noDataText: e(t).monomerId ? "暂无数据" : "未选择单体", placeholder: "选择区域筛选", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "noDataText", "onChange"])) : y("", true)];
    }), viewLeft: f(() => [d(b, { class: "filter-item", effect: "plain", size: "large" }, { default: f(() => [S(" 文件导入仅支持" + C(E.value) + "格式、ZIP压缩包格式（内容为" + C(E.value) + "格式） ", 1)]), _: 1 }), d(Q, { "module-type": e(B).PLAN_MANAGEMENT.V, "component-name-list": e(H).PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V, APPtotal: m.APPtotal, rejTotal: m.rejTotal, subTotal: m.subTotal, style: { "margin-left": "10px", "padding-right": "10px" }, onHandleSuccess: () => e(s).toQuery() }, null, 8, ["module-type", "component-name-list", "APPtotal", "rejTotal", "subTotal"])]), _: 1 }), d(U, { modelValue: i.value, "onUpdate:modelValue": a[4] || (a[4] = (r) => i.value = r), form: o.value, onSuccess: a[5] || (a[5] = (r) => e(s).toQuery()) }, null, 8, ["modelValue", "form"])]);
  };
} };
export {
  z as default
};
