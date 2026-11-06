import { ref as d } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createElementVNode as S } from "vue";
import { withCtx as y } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as N } from "vue";
import { createTextVNode as x } from "vue";
import { ElInput as O } from "element-plus";
import { a as I } from "../../../../../../modules/craft-library-fde84566.js";
import { oG as r, B as L, tH as W, fv as _, a3 as b, tJ as k, tI as z, aS as H, C as R, E as G } from "../../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../../modules/process-select-b35dffc0.js";
import { u as F } from "../../../../../../modules/use-capp-dict-d7ec0720.js";
import { c as j } from "./craft-library-table.vue.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
import "../../../../../../modules/html2canvas.esm-e0a7d97b.js";
const J = { class: "head-container" }, oe = { __name: "header", setup($) {
  const { cappDict: w, fetchCappDict: B } = F(), c = d(), u = d(false), f = d([]), C = d({ key: "dictValue", label: "dictValue", value: "dictValue" }), T = { enabledFlag: { value: void 0, resetAble: false }, processStatus: { value: void 0, resetAble: false }, processAttributes: { value: void 0, resetAble: false }, craftType: { value: r.WELDING.V, resetAble: false }, projectId: void 0, serialNumber: "", weldingBaseWeldingMethod: "", weldingBaseWeldingPosition: "", weldingBaseWeldingDeviceType: "", weldingBaseParentMaterialSteelGrade: "", weldingBaseHotRollingOrHeatTreatmentStatus: "", weldingBasePlateThicknessOrPipeDiameter: "" }, { query: a, crud: i, CRUD: h } = L(T);
  async function v() {
    var m;
    try {
      u.value = true;
      const l = i.selections.map((n) => n.id);
      f.value = await I(l), await ((m = c.value) == null ? void 0 : m.downloadPdf());
    } catch (l) {
      console.log("下载PDF失败", l);
    } finally {
      u.value = false;
    }
  }
  return h.HOOK.afterSubmit = () => {
    B();
  }, (m, l) => {
    var g;
    const n = p("common-radio-button"), P = p("common-select"), s = O, U = p("common-button"), D = E("permission");
    return V(), M("div", J, [o(n, { modelValue: e(a).craftType, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).craftType = t), options: e(r).ENUM, disabledVal: [e(r).CUTTING.V, e(r).COATING.V], type: "enum", class: "filter-item", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"]), o(n, { modelValue: e(a).processAttributes, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).processAttributes = t), options: e(W).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(_), { modelValue: e(a).projectId, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(a).projectId = t), placeholder: "工程项目", style: { width: "222px" }, clearable: "", class: "filter-item", onChange: e(i).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(Q), { modelValue: e(a).processId, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(a).processId = t), multiple: false, clearable: "", "product-type": e(b).ARTIFACT.V + e(b).ASSEMBLE.V, placeholder: "关联工序", class: "filter-item", style: { width: "160px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "product-type", "onChange"]), o(P, { modelValue: e(a).weldingBaseJointType, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(a).weldingBaseJointType = t), options: (g = e(w)) == null ? void 0 : g[e(k).WELDING_BASE_JOINT_TYPE.V], type: "other", dataStructure: C.value, size: "default", clearable: "", filterable: "", placeholder: "接头形式", class: "filter-item", style: { width: "160px" }, onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "dataStructure", "onChange"]), o(s, { modelValue: e(a).serialNumber, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(a).serialNumber = t), modelModifiers: { trim: true }, clearable: "", placeholder: "工艺编号搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(s, { modelValue: e(a).weldingBaseHotRollingOrHeatTreatmentStatus, "onUpdate:modelValue": l[6] || (l[6] = (t) => e(a).weldingBaseHotRollingOrHeatTreatmentStatus = t), modelModifiers: { trim: true }, clearable: "", placeholder: "轧制或热处理状态搜索", size: "default", class: "filter-item", style: { width: "161px" } }, null, 8, ["modelValue"]), S("div", null, [o(n, { modelValue: e(a).processStatus, "onUpdate:modelValue": l[7] || (l[7] = (t) => e(a).processStatus = t), options: e(z).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(n, { modelValue: e(a).enabledFlag, "onUpdate:modelValue": l[8] || (l[8] = (t) => e(a).enabledFlag = t), options: e(H).ENUM, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(s, { modelValue: e(a).weldingBaseWeldingMethod, "onUpdate:modelValue": l[9] || (l[9] = (t) => e(a).weldingBaseWeldingMethod = t), modelModifiers: { trim: true }, clearable: "", placeholder: "焊接方法搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(s, { modelValue: e(a).weldingBaseWeldingPosition, "onUpdate:modelValue": l[10] || (l[10] = (t) => e(a).weldingBaseWeldingPosition = t), modelModifiers: { trim: true }, clearable: "", placeholder: "焊接位置搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(s, { modelValue: e(a).weldingBaseWeldingDeviceType, "onUpdate:modelValue": l[11] || (l[11] = (t) => e(a).weldingBaseWeldingDeviceType = t), modelModifiers: { trim: true }, clearable: "", placeholder: "焊接设备型号搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(s, { modelValue: e(a).weldingBaseParentMaterialSteelGrade, "onUpdate:modelValue": l[12] || (l[12] = (t) => e(a).weldingBaseParentMaterialSteelGrade = t), modelModifiers: { trim: true }, clearable: "", placeholder: "母材钢号搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(s, { modelValue: e(a).weldingBasePlateThicknessOrPipeDiameter, "onUpdate:modelValue": l[13] || (l[13] = (t) => e(a).weldingBasePlateThicknessOrPipeDiameter = t), modelModifiers: { trim: true }, clearable: "", placeholder: "板厚或管径×壁厚搜索", size: "default", class: "filter-item", style: { width: "160px" } }, null, 8, ["modelValue"]), o(e(R))]), o(e(G), null, { optRight: y(() => {
      var t;
      return [A((V(), N(U, { disabled: !((t = e(i).selections) != null && t.length), loading: u.value, class: "filter-item", size: "default", type: "warning", icon: "el-icon-download", onClick: v }, { default: y(() => l[14] || (l[14] = [x(" 下载PDF ")])), _: 1, __: [14] }, 8, ["disabled", "loading"])), [[D, e(i).permission.downloadPDF]])];
    }), _: 1 }), o(e(j), { ref_key: "craftLibraryTableRef", ref: c, detailList: f.value }, null, 8, ["detailList"])]);
  };
} };
export {
  oe as default
};
