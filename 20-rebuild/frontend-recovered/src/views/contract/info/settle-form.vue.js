import { ref as T } from "vue";
import { computed as W } from "vue";
import { watch as H } from "vue";
import { nextTick as K } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as n } from "vue";
import { createBlock as f } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as v } from "vue";
import { unref as a } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as S } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as V } from "vue";
import { createVNode as m } from "vue";
import { withDirectives as X } from "vue";
import { renderList as L } from "vue";
import { isRef as Y } from "vue";
import { ElNotification as U } from "element-plus";
import { ElMessageBox as Z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { ElFormItem as te } from "element-plus";
import { ElInputNumber as ae } from "element-plus";
import { ElDatePicker as le } from "element-plus";
import { ElForm as ne } from "element-plus";
import { _ as se, t as ie, u as oe, bC as ue, c3 as c, z as F, bV as A, ia as M, i as de, p as re, S as me, L as ce, ir as fe, iu as ye, it as pe } from "../../../shared/runtime.js";
import ve from "./components/user-dept-cascader.vue.js";
import { _ as ge } from "../../../modules/UploadBtn-b4cfb47a.js";
const be = { class: "dialog-title" }, he = { style: { position: "absolute", right: "20px" } }, Se = { key: 0 }, Ve = { key: 0 }, ke = { key: 0 }, Ie = { key: 1 }, Ee = { key: 1 }, Ae = { __name: "settle-form", props: { projectId: [Number, String], auditStatus: [Number, String], modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, memberList: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(t, { emit: R }) {
  const { decimalPrecision: k } = ie(), g = t, w = { id: void 0, projectId: "", settlementAmount: void 0, changeDate: "", userList: [], attachments: void 0, attachmentIds: void 0 }, l = T(JSON.parse(JSON.stringify(w))), y = T(), j = T(), B = { settlementAmount: { required: true, validator: (i, e, r) => {
    e <= 0 ? r(new Error("结算金额必须大于0")) : r();
  }, trigger: "change" }, userList: { required: true, validator: (i, e, r) => {
    e.length ? r() : r(new Error("请选择负责人"));
  }, trigger: "change" }, changeDate: { required: true, message: "请选择结算日期", trigger: "blur" } }, N = R, { visible: I, handleClose: E } = oe({ emit: N, props: g }), C = W(() => g.detailInfo.contractAmount && l.value.settlementAmount ? l.value.settlementAmount - g.detailInfo.contractAmount : "");
  H(() => I.value, (i) => {
    i && (g.auditStatus || z());
  }, { deep: true, immediate: true });
  function z(i) {
    y.value && y.value.resetFields(), i && Object.keys(i).length > 0 ? l.value = i : l.value = JSON.parse(JSON.stringify(w)), y.value && K(() => {
      y.value.clearValidate();
    }), ue(y, l);
  }
  async function O() {
    try {
      if (!await y.value.validate()) return;
      l.value.projectId = g.projectId, l.value.attachmentIds = l.value.attachments ? l.value.attachments.map((r) => r.id) : void 0;
      const e = { type: fe.CONTRACT_SETTLE.V, ...l.value };
      await ye(e), U({ title: "提交成功", type: "success" }), N("success"), E();
    } catch (i) {
      console.log("项目结算失败", i);
    }
  }
  const _ = (i) => (!i || !i.trim()) && i !== 0 ? "必填" : i.length > 200 ? "长度在 1 到 200 个字符" : true;
  async function D(i) {
    try {
      const e = i === c.PASS.V ? "通过" : "驳回", r = await Z.prompt("请输入审核说明", e, { confirmButtonText: "确定", cancelButtonText: "取消", inputType: "textarea", inputValidator: _, type: "warning" }), b = { auditStatus: i, id: g.detailInfo.id, remark: r.value };
      await pe(b), U({ title: "提交成功", type: "success" }), N("success"), E();
    } catch (e) {
      console.log("审核", e);
    }
  }
  return (i, e) => {
    const r = ee, b = x("common-button"), p = te, J = ae, P = le, q = ne, $ = x("common-dialog"), G = Q("show-thousand");
    return n(), f($, { "append-to-body": "", modelValue: a(I), "onUpdate:modelValue": e[6] || (e[6] = (s) => Y(I) ? I.value = s : null), top: "10vh", width: "600px", "before-close": a(E), title: "项目结算", center: false, "close-on-click-modal": false }, { title: o(() => [v("div", be, [e[11] || (e[11] = v("span", { class: "title-left" }, "项目结算", -1)), t.auditStatus ? (n(), f(r, { key: 0, size: "large", type: t.auditStatus == a(c).ENUM.REJECT.V ? "info" : t.auditStatus == a(c).ENUM.PASS.V ? "success" : "warning" }, { default: o(() => [h(d(t.auditStatus == a(c).ENUM.REJECT.V ? "已驳回" : t.auditStatus == a(c).ENUM.PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : S("", true), v("span", he, [t.auditStatus ? (n(), u(V, { key: 0 }, [t.auditStatus == a(c).ENUM.AUDITING.V && t.showType === "audit" ? (n(), f(b, { key: 0, size: "default", type: "info", onClick: e[0] || (e[0] = (s) => D(a(c).ENUM.REJECT.V)) }, { default: o(() => e[7] || (e[7] = [h("驳回")])), _: 1, __: [7] })) : S("", true), t.auditStatus == a(c).ENUM.AUDITING.V && t.showType === "audit" ? (n(), f(b, { key: 1, size: "default", type: "success", onClick: e[1] || (e[1] = (s) => D(a(c).ENUM.PASS.V)) }, { default: o(() => e[8] || (e[8] = [h("通过")])), _: 1, __: [8] })) : S("", true)], 64)) : (n(), f(b, { key: 1, type: "primary", size: "default", onClick: O }, { default: o(() => e[9] || (e[9] = [h("提交")])), _: 1, __: [9] })), m(b, { size: "default", onClick: a(E) }, { default: o(() => e[10] || (e[10] = [h("关闭")])), _: 1, __: [10] }, 8, ["onClick"])])])]), default: o(() => [m(q, { ref_key: "formRef", ref: y, model: l.value, rules: B, size: "default", "label-width": "150px" }, { default: o(() => [m(p, { label: "项目", prop: "serialNumber" }, { default: o(() => [t.auditStatus ? (n(), u(V, { key: 1 }, [t.detailInfo.project ? (n(), u("span", Ve, d(a(F)(t.detailInfo.project)), 1)) : S("", true)], 64)) : (n(), u("span", Se, d(a(F)(t.detailInfo)), 1))]), _: 1 }), m(p, { label: "合同金额", prop: "serialNumber" }, { default: o(() => [v("span", null, d(a(A)(t.detailInfo.contractAmount, a(k).contract)), 1)]), _: 1 }), m(p, { label: "结算金额（元）", prop: "settlementAmount" }, { default: o(() => [t.auditStatus ? (n(), u(V, { key: 1 }, [v("span", null, d(a(A)(t.detailInfo.settlementAmount, a(k).contract)), 1), v("div", null, d(a(M)(t.detailInfo.settlementAmount)), 1)], 64)) : (n(), u(V, { key: 0 }, [X(m(J, { modelValue: l.value.settlementAmount, "onUpdate:modelValue": e[2] || (e[2] = (s) => l.value.settlementAmount = s), max: 9999999999, min: 0, step: 100, precision: a(k).contract, "controls-position": "right", placeholder: "结算金额（元）", style: { width: "320px" } }, null, 8, ["modelValue", "precision"]), [[G]]), v("div", null, d(l.value.settlementAmount ? a(M)(l.value.settlementAmount) : ""), 1)], 64))]), _: 1 }), m(p, { label: "结算差异(元)", prop: "newAmount" }, { default: o(() => [t.auditStatus ? (n(), u("span", Ie, d(a(A)(t.detailInfo.settlementAmount - t.detailInfo.contractAmount, a(k).contract)), 1)) : (n(), u("span", ke, d(a(de)(C.value) ? a(A)(C.value, a(k).contract) : ""), 1))]), _: 1 }), m(p, { label: "结算日期", prop: "changeDate" }, { default: o(() => [t.auditStatus ? (n(), u("span", Ee, d(t.detailInfo.changeDate ? a(re)(t.detailInfo.changeDate, "{y}-{m}-{d}") : "-"), 1)) : (n(), f(P, { key: 0, modelValue: l.value.changeDate, "onUpdate:modelValue": e[3] || (e[3] = (s) => l.value.changeDate = s), type: "date", "value-format": "x", placeholder: "结算日期", style: { width: "320px" }, disabledDate: (s) => s.getTime() < (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3 }, null, 8, ["modelValue", "disabledDate"]))]), _: 1 }), m(p, { label: "负责人", prop: "userList" }, { default: o(() => [t.auditStatus ? (n(true), u(V, { key: 1 }, L(t.detailInfo.leaderList, (s) => (n(), u("span", { key: s.id }, d(s.name), 1))), 128)) : (n(), f(a(ve), { key: 0, modelValue: l.value.userList, "onUpdate:modelValue": e[4] || (e[4] = (s) => l.value.userList = s), multiple: "", filterable: "", clearable: "", "show-all-levels": "", placeholder: "负责人", noDisabledVal: t.memberList, style: { width: "320px" } }, null, 8, ["modelValue", "noDisabledVal"]))]), _: 1 }), m(p, { label: "附件" }, { default: o(() => [t.auditStatus ? S("", true) : (n(), f(a(ge), { key: 0, ref_key: "uploadRef", ref: j, files: l.value.attachments, "onUpdate:files": e[5] || (e[5] = (s) => l.value.attachments = s), "file-classify": a(me).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"])), t.auditStatus && t.detailInfo.attachmentList && t.detailInfo.attachmentList.length > 0 ? (n(true), u(V, { key: 1 }, L(t.detailInfo.attachmentList, (s) => (n(), u("div", { key: s.id }, [h(d(s.name) + " ", 1), m(ce, { params: { id: s.id } }, null, 8, ["params"])]))), 128)) : S("", true)]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Le = se(Ae, [["__scopeId", "data-v-014b2982"]]);
export {
  Le as default
};
