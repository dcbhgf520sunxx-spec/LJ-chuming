import { ref as c } from "vue";
import { watch as B } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as p } from "vue";
import { createBlock as b } from "vue";
import { withCtx as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as F } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as M } from "vue";
import { toDisplayString as N } from "vue";
import { createElementBlock as O } from "vue";
import { isRef as P } from "vue";
import { ElNotification as Y } from "element-plus";
import { ElDescriptionsItem as G } from "element-plus";
import { ElDatePicker as $ } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElDescriptions as J } from "element-plus";
import { ElForm as K } from "element-plus";
import { g as Q } from "../../../../../modules/visa-manage-fd5a2300.js";
import { _ as X, m as Z, g8 as ee, u as le, G as ae, u1 as d, bN as h, S as te, u4 as se } from "../../../../../shared/runtime.js";
import { _ as oe } from "../../../../../modules/PicUpload-8580ccfc.js";
import { _ as ne } from "../../../../../modules/project-visa-select-e1b3658e.js";
import { _ as re } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const ue = { key: 1 }, ie = { __name: "create-visa-form", props: { modelValue: { type: Boolean, require: true }, selections: { type: Array, default: () => [] }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success", "del-change"], setup(v, { emit: k }) {
  const { user: E } = Z(["user"]), D = ee(["visa_reason"]), g = k, y = v, V = c(), e = c({}), j = { visaDate: [{ required: true, message: "请选择日期", trigger: ["change", "blur"] }], mode: [{ required: true, message: "请选择类别", trigger: ["change", "blur"] }], projectId: [{ required: true, message: "请选择项目", trigger: ["change", "blur"] }], supplierId: [{ required: true, message: "请选择签证对象", trigger: ["change", "blur"] }], reasonId: [{ required: true, message: "请选择事由", trigger: ["change", "blur"] }], visaAmount: [{ required: true, message: "请输入费用", trigger: ["change", "blur"] }], remark: [{ required: true, message: "请输入备注", trigger: ["change", "blur"] }] }, { visible: m, handleClose: I } = le({ emit: g, props: y });
  B(m, (i) => {
    i && (U.value = y.selections);
  });
  const U = c([]), R = c();
  async function T(i) {
    let l = {};
    try {
      i && (l = await Q(i));
    } catch (u) {
      console.log("获取项目详情失败", u);
    } finally {
      e.value.recipients = l.customerUnit;
    }
  }
  async function C() {
    var l;
    if (await V.value.validate()) try {
      const u = (l = e.value.picAttament) == null ? void 0 : l.map((f) => f.id), n = { ...e.value, attachmentIds: u };
      await se(n), Y({ title: "提交成功", type: "success" }), g("success"), I();
    } catch (u) {
      console.log("提交失败", u);
    }
  }
  return (i, l) => {
    const u = _("common-button"), n = G, f = $, r = H, A = _("common-select"), w = W, q = J, x = K, S = _("common-drawer");
    return p(), b(S, { ref_key: "drawerRef", ref: R, title: "创建签证", "close-on-click-modal": false, modelValue: o(m), "onUpdate:modelValue": l[8] || (l[8] = (s) => P(m) ? m.value = s : null), direction: "rtl", "before-close": o(I), "custom-class": "summary-detail", size: "50%" }, { titleRight: t(() => [o(ae)(v.permission.save) ? (p(), b(u, { key: 0, type: "success", size: "default", onClick: C }, { default: t(() => l[9] || (l[9] = [L("保存")])), _: 1, __: [9] })) : F("", true)]), content: t(() => [a(x, { ref_key: "formRef", ref: V, model: e.value, rules: j, class: "demo-form" }, { default: t(() => [a(q, { column: 2, border: "" }, { default: t(() => [a(n, { "label-align": "center", label: "创建人" }, { default: t(() => {
      var s;
      return [M("span", null, N((s = o(E)) == null ? void 0 : s.name), 1)];
    }), _: 1 }), a(n, { "label-align": "center", label: "日期", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "visaDate" }, { default: t(() => [a(f, { modelValue: e.value.visaDate, "onUpdate:modelValue": l[0] || (l[0] = (s) => e.value.visaDate = s), type: "date", size: "default", "value-format": "x", format: "YYYY-MM-DD", class: "input-underline", style: { width: "100%" }, placeholder: "选择日期" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "类别", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "mode" }, { default: t(() => [a(A, { modelValue: e.value.mode, "onUpdate:modelValue": l[1] || (l[1] = (s) => e.value.mode = s), options: o(d).ENUM, type: "enum", size: "default", clearable: "", placeholder: "选择类别", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "项目", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "projectId" }, { default: t(() => [a(o(ne), { modelValue: e.value.projectId, "onUpdate:modelValue": l[2] || (l[2] = (s) => e.value.projectId = s), style: { width: "100%" }, businessType: e.value.mode === o(d).INTERNAL_VISA.V ? o(h).INSTALLATION.V : o(h).MACHINING.V, disabled: !e.value.mode, class: "input-underline", placeholder: "选择项目", clearable: "", onChange: T }, null, 8, ["modelValue", "businessType", "disabled"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "签证对象", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: e.value.mode === o(d).INTERNAL_VISA.V ? "supplierId" : e.value.mode === o(d).OUTWARD_VISA.V ? "recipients" : "supplierId" }, { default: t(() => {
      var s;
      return [e.value.mode === o(d).INTERNAL_VISA.V ? (p(), b(re, { key: 0, modelValue: e.value.supplierId, "onUpdate:modelValue": l[3] || (l[3] = (z) => e.value.supplierId = z), projectId: e.value.projectId, clearable: "", disabled: !e.value.mode, class: "input-underline", placeholder: "选择签证对象", style: { width: "100%" } }, null, 8, ["modelValue", "projectId", "disabled"])) : (p(), O("span", ue, N((s = e.value) == null ? void 0 : s.recipients), 1))];
    }), _: 1 }, 8, ["prop"])]), _: 1 }), a(n, { "label-align": "center", label: "事由", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "reasonId" }, { default: t(() => [a(A, { modelValue: e.value.reasonId, "onUpdate:modelValue": l[4] || (l[4] = (s) => e.value.reasonId = s), options: o(D).visa_reason, clearable: "", filterable: "", class: "input-underline", type: "dict", size: "default", style: { width: "100%" }, placeholder: "请填写事由" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "费用", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "visaAmount" }, { default: t(() => [a(w, { modelValue: e.value.visaAmount, "onUpdate:modelValue": l[5] || (l[5] = (s) => e.value.visaAmount = s), maxlength: "9999999999999", type: "number", placeholder: "请填写费用", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "备注", "label-class-name": "my-label" }, { default: t(() => [a(r, { prop: "remark" }, { default: t(() => [a(w, { modelValue: e.value.remark, "onUpdate:modelValue": l[6] || (l[6] = (s) => e.value.remark = s), placeholder: "请填写备注", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(n, { "label-align": "center", label: "图片" }, { default: t(() => [a(r, { prop: "picAttament" }, { default: t(() => [a(o(oe), { files: e.value.picAttament, "onUpdate:files": l[7] || (l[7] = (s) => e.value.picAttament = s), "file-classify": o(te).NORMAL.V, style: { width: "100%" } }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, be = X(ie, [["__scopeId", "data-v-5c659b44"]]);
export {
  be as default
};
