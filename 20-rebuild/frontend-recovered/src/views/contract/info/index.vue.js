import { ref as t } from "vue";
import { watch as X } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as w } from "vue";
import { createBlock as R } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as a } from "vue";
import { Transition as Y } from "vue";
import { withDirectives as Z } from "vue";
import { unref as l } from "vue";
import { ElTabs as $ } from "element-plus";
import { ElTabPane as k } from "element-plus";
import { createCommentVNode as E } from "vue";
import { vShow as ee } from "vue";
import { createTextVNode as te } from "vue";
import { toDisplayString as ae } from "vue";
import { isRef as oe } from "vue";
import { ElNotification as le } from "element-plus";
import { ElInput as se } from "element-plus";
import { ElFormItem as ne } from "element-plus";
import { ElDatePicker as re } from "element-plus";
import { ElForm as ue } from "element-plus";
import { _ as ie, m as me, u as de, iu as ce, ir as fe } from "../../../shared/runtime.js";
import pe from "./zn-base.vue.js";
import ve from "./customer.vue.js";
import be from "./members.vue.js";
import ye from "./money-form.vue.js";
import ge from "./settle-form.vue.js";
import Ve from "./variation-order.vue.js";
import "../../../modules/region-cascader-39b54da2.js";
import "./components/user-dept-cascader.vue.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const _e = { style: { "margin-bottom": "10px", position: "relative" } }, Ie = { __name: "index", props: { projectId: { type: [Number, String], default: void 0 }, projectStatus: { type: [Number, String], default: void 0 }, projectName: { type: String, default: void 0 }, modelValue: { type: Boolean, require: true }, btnShow: { type: Boolean, default: true } }, emits: ["success", "update:modelValue"], setup(n, { emit: O }) {
  const p = n, { user: P } = me("user"), B = O, { visible: v, handleClose: i } = de({ emit: B, props: p }), T = t("contract"), m = t("baseInfo"), r = t(false), U = t(false), S = t(false), F = t(false);
  t(false);
  const b = t(), d = t(), y = t(), c = t(), f = t(), g = t(), V = t([]), M = t(), z = t(), q = t(), _ = t(false), N = t(), u = t({ changeDesc: void 0, changeDate: (/* @__PURE__ */ new Date()).getTime() }), L = { changeDesc: [{ required: true, message: "请填写变更原因描述", trigger: "blur" }], changeDate: [{ required: true, message: "请选择日期", trigger: "change" }] };
  X(() => p.projectId, (I) => {
    I && (T.value = "contract", m.value = "baseInfo");
  }, { deep: true, immediate: true });
  function A() {
    r.value && (d.value.resetForm(), y.value.resetForm(), c.value.resetForm(), f.value.fetchMembers(), r.value = false), m.value = "baseInfo", i();
  }
  async function G() {
    if (!await N.value.validate()) return;
    const e = { baseUpdateDTOParam: d.value.form, businessUpdateDTOParam: y.value.form, customerUpdateDTOParam: c.value.form, userIdList: f.value.checkedList };
    e.businessUpdateDTOParam.signerId = e.baseUpdateDTOParam.signerId;
    try {
      await ce({ projectId: p.projectId, type: fe.ENUM.CONTRACT_INFO.V, projectUpdateDTOParam: e, ...u.value }), le({ title: "提交成功", type: "success" }), d.value.resetForm(), y.value.resetForm(), c.value.resetForm(), f.value.fetchMembers(), r.value = false, C(), i();
    } catch (j) {
      console.log("合同信息更新失败", j);
    }
  }
  function C() {
    _.value = false;
  }
  return (I, e) => {
    const j = D("common-button"), H = se, h = ne, J = re, K = ue, Q = D("common-dialog"), W = D("common-drawer");
    return w(), R(W, { "append-to-body": "", modelValue: l(v), "onUpdate:modelValue": e[7] || (e[7] = (o) => oe(v) ? v.value = o : null), top: "10vh", width: "600px", "before-close": A, title: "合同信息", "wrapper-closable": false, size: "65%" }, { content: s(() => [x("div", null, [a(Y, { name: "el-fade-in" }, { default: s(() => [Z(x("div", _e, [n.projectId ? (w(), R(l($), { key: 0, modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => m.value = o) }, { default: s(() => [a(l(k), { label: "基础信息", name: "baseInfo" }, { default: s(() => [a(l(pe), { ref_key: "baseRef", ref: d, class: "tab-content", "project-id": n.projectId, "is-modify": r.value }, null, 8, ["project-id", "is-modify"])]), _: 1 }), a(l(k), { label: "客户信息", name: "customerInfo" }, { default: s(() => [a(l(ve), { ref_key: "customerRef", ref: c, class: "tab-content", "project-id": n.projectId, "is-modify": r.value }, null, 8, ["project-id", "is-modify"])]), _: 1 }), a(l(k), { label: "项目成员", name: "memberInfo" }, { default: s(() => [n.projectId ? (w(), R(l(be), { key: 0, ref_key: "memberRef", ref: f, "project-id": n.projectId, "is-modify": r.value }, null, 8, ["project-id", "is-modify"])) : E("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"])) : E("", true)], 512), [[ee, T.value == "contract"]])]), _: 1 }), a(Q, { "append-to-body": "", modelValue: _.value, "onUpdate:modelValue": e[3] || (e[3] = (o) => _.value = o), top: "10vh", width: "600px", "before-close": C, title: "合同变更", center: false, "close-on-click-modal": false }, { titleRight: s(() => [a(j, { type: "primary", size: "default", onClick: G }, { default: s(() => e[8] || (e[8] = [te("提交")])), _: 1, __: [8] })]), default: s(() => [a(K, { ref_key: "changeFormRef", ref: N, model: u.value, rules: L, size: "default", "label-width": "150px" }, { default: s(() => [a(h, { label: "变更原因描述", prop: "changeDesc" }, { default: s(() => [a(H, { modelValue: u.value.changeDesc, "onUpdate:modelValue": e[1] || (e[1] = (o) => u.value.changeDesc = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "请填写描述", style: { width: "320px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "变更日期", prop: "changeDate" }, { default: s(() => [a(J, { modelValue: u.value.changeDate, "onUpdate:modelValue": e[2] || (e[2] = (o) => u.value.changeDate = o), type: "date", "value-format": "x", placeholder: "变更日期", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "操作人", prop: "changeDate" }, { default: s(() => [x("span", null, ae(l(P).name), 1)]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]), a(l(ye), { ref_key: "moneyRef", ref: M, "audit-status": b.value, "project-id": n.projectId, modelValue: U.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => U.value = o), "detail-info": g.value, onSuccess: l(i), "member-list": V.value }, null, 8, ["audit-status", "project-id", "modelValue", "detail-info", "onSuccess", "member-list"]), a(l(ge), { ref_key: "settleRef", ref: z, "audit-status": b.value, "project-id": n.projectId, modelValue: S.value, "onUpdate:modelValue": e[5] || (e[5] = (o) => S.value = o), "detail-info": g.value, onSuccess: l(i), "member-list": V.value }, null, 8, ["audit-status", "project-id", "modelValue", "detail-info", "onSuccess", "member-list"]), a(l(Ve), { ref_key: "variationRef", ref: q, "audit-status": b.value, "project-id": n.projectId, modelValue: F.value, "onUpdate:modelValue": e[6] || (e[6] = (o) => F.value = o), "detail-info": g.value, onSuccess: l(i), "member-list": V.value }, null, 8, ["audit-status", "project-id", "modelValue", "detail-info", "onSuccess", "member-list"])])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Ce = ie(Ie, [["__scopeId", "data-v-57f56d6a"]]);
export {
  Ce as default
};
