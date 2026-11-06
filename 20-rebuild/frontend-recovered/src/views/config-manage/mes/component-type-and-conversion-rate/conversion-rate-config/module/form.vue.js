import { ref as j } from "vue";
import { inject as $ } from "vue";
import { computed as y } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { withModifiers as q } from "vue";
import { createCommentVNode as H } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { ElCascader as J } from "element-plus";
import { ElForm as Q } from "element-plus";
import { a_ as W, dM as b, aw as X } from "../../../../../../shared/runtime.js";
import { u as Y } from "../../../../../../modules/use-table-operate-4f84437f.js";
import { _ as Z } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const ee = { style: { float: "right" } }, oe = { style: { "text-align": "center" } }, ie = { __name: "form", props: { artifactCurrentRow: { type: Object, default: () => ({}) } }, setup(h) {
  const C = h, g = j(), R = $("machinePartProcess"), v = { mesProcessConversionRateList: [{ conversionRate: void 0, processType: void 0, processIds: [] }] }, T = { conversionRate: void 0, processType: void 0, processIds: [] }, { CRUD: f, crud: i, form: a, ADD_FORM: V } = W(v, g), k = y(() => i.bStatus.cu > f.STATUS.NORMAL), { init: U, addRow: I, removeRow: P } = Y(T, 1), x = { conversionRate: [{ required: true, message: "请输入折合完工率", trigger: "change" }], processType: [{ required: true, message: "请输入工序类型", trigger: "change" }], processIds: [{ required: true, message: "请输入工序", trigger: "change" }] }, E = y(() => ({ value: "id", label: "name", children: "nameInfos", expandTrigger: "hover", multiple: true, emitPath: false })), { tableValidate: L, cleanUpData: S, wrongCellMask: M } = X({ rules: x, errorMsg: "请填写表格中标红的信息" });
  V.init = () => {
    U(a.mesProcessConversionRateList);
  }, f.HOOK.beforeValidateBCU = () => {
    const { validResult: l, dealList: r } = L(a.mesProcessConversionRateList);
    if (l) a.artifactClassId = C.artifactCurrentRow.id, a.mesProcessConversionRateList.forEach((c) => {
      c.processIds = c.processIds.join(",");
    });
    else return l;
  }, i.submitBatchFormFormat = (l) => (S(l.mesProcessConversionRateList), l);
  function N(l) {
    l.processIds = void 0;
  }
  return (l, r) => {
    const c = p("common-button"), d = K, B = G, z = p("common-select"), O = J, A = p("common-table"), F = Q, D = p("common-dialog");
    return m(), u(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: k.value, title: e(i).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "60%", top: "10vh" }, { titleRight: t(() => [w("span", ee, [s(c, { loading: e(i).bStatus.cu === e(f).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(i).submitBCU }, { default: t(() => r[1] || (r[1] = [_(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), s(c, { size: "default", onClick: e(i).cancelBCU }, { default: t(() => r[2] || (r[2] = [_("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: t(() => [s(F, { ref_key: "formRef", ref: g, model: e(a), rules: l.rules, size: "default", "label-width": "80px" }, { default: t(() => [s(A, { ref: "detailRef", border: "", data: e(a).mesProcessConversionRateList, style: { width: "100%", "margin-top": "10px" }, class: "upload-table", "return-source-data": "", "max-height": "500px", showEmptySymbol: false, "cell-class-name": e(M) }, { default: t(() => [s(d, { label: "序号", type: "index", align: "center", width: "50" }), s(d, { key: "conversionRate", prop: "conversionRate", label: "折合完工率（%）", align: "center" }, { default: t((o) => [s(B, { modelValue: o.row.conversionRate, "onUpdate:modelValue": (n) => o.row.conversionRate = n, modelModifiers: { number: true }, min: 0, max: 100, precision: 2, step: 1, placeholder: "请填写", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(d, { key: "processType", prop: "processType", label: "工序类型", align: "center" }, { default: t((o) => [s(z, { modelValue: o.row.processType, "onUpdate:modelValue": (n) => o.row.processType = n, options: e(b).ENUM, "unshow-options": [e(b).ENCLOSURE.K], clearable: "", type: "enum", size: "default", placeholder: "请选择工序类型", class: "filter-item", style: { width: "200px" }, onChange: (n) => N(o.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-options", "onChange"])]), _: 1 }), s(d, { key: "processIds", prop: "processIds", label: "工序", align: "center", "min-width": "160" }, { default: t((o) => [o.row.processType === e(b).MACHINE_PART.V ? (m(), u(O, { key: 0, ref: "processIdRef", options: e(R), "check-strictly": "", modelValue: o.row.processIds, "onUpdate:modelValue": (n) => o.row.processIds = n, disabled: !o.row.processType, props: E.value, separator: " > ", "show-all-levels": "", clearable: "", "collapse-tags": "", size: "default", style: { width: "340px" }, placeholder: "选择工序" }, null, 8, ["options", "modelValue", "onUpdate:modelValue", "disabled", "props"])) : (m(), u(e(Z), { key: 1, ref: "processSelectRef", modelValue: o.row.processIds, "onUpdate:modelValue": (n) => o.row.processIds = n, productType: o.row.processType, disabled: !o.row.processType, size: "default", filterable: "", clearable: "", multiple: "", style: { width: "340px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "productType", "disabled"]))]), _: 1 }), e(a).id ? H("", true) : (m(), u(d, { key: 0, label: "操作", align: "center", width: "100" }, { default: t(({ $index: o }) => [s(c, { size: "default", icon: "el-icon-delete", type: "danger", onClick: q((n) => e(P)(e(a).mesProcessConversionRateList, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["model", "rules"]), w("div", oe, [s(c, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: r[0] || (r[0] = (o) => e(I)(e(a).mesProcessConversionRateList)) }, { default: t(() => r[3] || (r[3] = [_(" 添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ie as default
};
