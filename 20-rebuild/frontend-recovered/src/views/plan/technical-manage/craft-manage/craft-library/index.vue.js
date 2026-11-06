import { ref as b } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as i } from "vue";
import { withCtx as g } from "vue";
import { createCommentVNode as o } from "vue";
import { toDisplayString as N } from "vue";
import { ElMessageBox as D } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElSwitch as E } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as H, e as M } from "../../../../../modules/craft-library-fde84566.js";
import { x as O, o as W, tH as R, tI as L, oG as U, G as v, aS as d, an as G, P as I } from "../../../../../shared/runtime.js";
import { D as m } from "../../../../../modules/plan-d12d7ccf.js";
import j from "./module/header.vue.js";
import J from "./module/detail.vue.js";
import $ from "./module/form.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/use-capp-dict-d7ec0720.js";
import "./module/craft-library-table.vue.js";
import "../../../../../modules/html2canvas.esm-e0a7d97b.js";
import "./module/preview.vue.js";
import "../../../../../modules/roster-34ff8428.js";
const q = { class: "app-container" }, Y = { key: 1 }, ce = { __name: "index", setup(z) {
  const u = b(), y = { batchAdd: false, add: true, edit: false, del: true, download: false }, { crud: s, columns: l, CRUD: x } = O({ title: "工艺卡", sort: [], permission: { ...m }, optShow: { ...y }, crudApi: { ...H } }, u), { maxHeight: _ } = W({ paginate: true }), B = b([["processAttributes", ["parse-enum", R]], ["processStatus", ["parse-enum", L]], ["craftType", ["parse-enum", U]], ["createTime", "parse-time"], ["updateTime", "parse-time"]]);
  async function k(p, c) {
    try {
      await D.confirm('此操作将 "' + d.VL[c] + '" ' + p.serialNumber + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await M({ id: p.id, enabledFlag: c }), s.refresh(), s.notify(d.VL[c] + "成功", x.NOTIFICATION_TYPE.SUCCESS);
    } catch (t) {
      console.log("修改状态失败", t), p.enabledFlag = !p.enabledFlag;
    }
  }
  return (p, c) => {
    const t = A, S = E, T = C("common-table"), P = V;
    return a(), f("div", q, [n(e(j)), F((a(), i(T, { ref_key: "tableRef", ref: u, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(_), "data-format": B.value, onSelectionChange: e(s).selectionChangeHandler }, { default: g(() => [n(t, { type: "selection", width: "55", align: "center" }), n(t, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("serialNumber") ? (a(), i(t, { key: "serialNumber", prop: "serialNumber", align: "center", label: "工艺编号", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("craftType") ? (a(), i(t, { key: "craftType", prop: "craftType", align: "center", label: "工艺类型", width: "80px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("processAttributes") ? (a(), i(t, { key: "processAttributes", prop: "processAttributes", align: "center", label: "工艺属性", width: "80px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("projectName") ? (a(), i(t, { key: "projectName", prop: "projectName", align: "center", label: "工程项目", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseWeldingMethod") ? (a(), i(t, { key: "weldingBaseWeldingMethod", prop: "weldingBaseWeldingMethod", align: "center", label: "焊接方法", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseJointType") ? (a(), i(t, { key: "weldingBaseJointType", prop: "weldingBaseJointType", align: "center", label: "接头形式", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseWeldingPosition") ? (a(), i(t, { key: "weldingBaseWeldingPosition", prop: "weldingBaseWeldingPosition", align: "center", label: "焊接位置", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseWeldingDeviceType") ? (a(), i(t, { key: "weldingBaseWeldingDeviceType", prop: "weldingBaseWeldingDeviceType", align: "center", label: "焊接设备型号", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseParentMaterialSteelGrade") ? (a(), i(t, { key: "weldingBaseParentMaterialSteelGrade", prop: "weldingBaseParentMaterialSteelGrade", align: "center", label: "母材钢号", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBasePlateThicknessOrPipeDiameter") ? (a(), i(t, { key: "weldingBasePlateThicknessOrPipeDiameter", prop: "weldingBasePlateThicknessOrPipeDiameter", align: "center", label: "板厚或管径×壁厚", width: "120px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBaseHotRollingOrHeatTreatmentStatus") ? (a(), i(t, { key: "weldingBaseHotRollingOrHeatTreatmentStatus", prop: "weldingBaseHotRollingOrHeatTreatmentStatus", align: "center", label: "轧制或热处理状态", width: "120px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("processName") ? (a(), i(t, { key: "processName", prop: "processName", align: "center", label: "关联工序", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("weldingBasePowerSupplyAndPolarity") ? (a(), i(t, { key: "weldingBasePowerSupplyAndPolarity", prop: "weldingBasePowerSupplyAndPolarity", align: "center", label: "电源及极性", "min-width": "100px", "show-overflow-tooltip": "" })) : o("", true), e(l).visible("processStatus") ? (a(), i(t, { key: "processStatus", prop: "processStatus", align: "center", label: "状态", width: "80px", "show-overflow-tooltip": "", fixed: "right" })) : o("", true), e(l).visible("enabledFlag") ? (a(), i(t, { key: "enabledFlag", prop: "enabledFlag", align: "center", label: "启 / 禁用", width: "80px", "show-overflow-tooltip": "", fixed: "right" }, { default: g(({ row: r }) => {
      var w;
      return [e(v)(e(m).editStatus) ? (a(), i(S, { key: 0, modelValue: r.enabledFlag, "onUpdate:modelValue": (h) => r.enabledFlag = h, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(d).TRUE.V, "inactive-value": e(d).FALSE.V, onClick: (h) => k(r, r.enabledFlag) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onClick"])) : (a(), f("span", Y, N((w = e(d).VL) == null ? void 0 : w[r.enabledFlag]), 1))];
    }), _: 1 })) : o("", true), e(l).visible("versionNumber") ? (a(), i(t, { key: "versionNumber", prop: "versionNumber", align: "center", label: "版本", width: "60px", "show-overflow-tooltip": "", fixed: "right" })) : o("", true), e(v)([...e(m).edit, ...e(m).del]) ? (a(), i(t, { key: 16, label: "操作", width: "170px", align: "center", fixed: "right" }, { default: g(({ row: r }) => [n(e(G), { data: r, showDetail: "" }, null, 8, ["data"])]), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format", "onSelectionChange"])), [[P, e(s).loading]]), n(e(I)), n(e(J)), n(e($))]);
  };
} };
export {
  ce as default
};
