import { ref as D } from "vue";
import { watch as K } from "vue";
import { nextTick as Q } from "vue";
import { computed as X } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as n } from "vue";
import { createBlock as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as x } from "vue";
import { unref as a } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as T } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as Z } from "vue";
import { normalizeClass as ee } from "vue";
import { renderList as L } from "vue";
import { isRef as te } from "vue";
import { ElNotification as R } from "element-plus";
import { ElMessageBox as ae } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElFormItem as le } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { ElInput as se } from "element-plus";
import { ElForm as ue } from "element-plus";
import { _ as de, t as re, u as ce, bC as me, c3 as y, z as M, bV as b, p as fe, iv as z, S as ye, L as pe, ir as ge, iu as he, it as ve } from "../../../shared/runtime.js";
import Ve from "./components/user-dept-cascader.vue.js";
import { _ as ke } from "../../../modules/UploadBtn-b4cfb47a.js";
const be = { class: "dialog-title" }, Ie = { style: { position: "absolute", right: "20px" } }, Se = { key: 0 }, Te = { key: 0 }, we = { key: 0 }, De = { key: 1 }, Ae = { key: 0 }, xe = { key: 1 }, Ce = { key: 1 }, Ee = { key: 1, class: "detail-break" }, Ne = { key: 1 }, Le = { __name: "variation-order", props: { projectId: [Number, String], auditStatus: [Number, String], modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, memberList: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(e, { emit: O }) {
  const { decimalPrecision: h } = re(), p = e, C = { id: void 0, projectId: "", changeMoney: void 0, changeAmount: void 0, changeContent: void 0, changeDate: "", userList: [], changeDesc: void 0, attachments: void 0, attachmentIds: void 0, payType: void 0 }, l = D(JSON.parse(JSON.stringify(C))), g = D(), j = D(), F = { changeMoney: { required: true, validator: (i, t, d) => {
    t <= 0 ? d(new Error("签证金额必须大于0")) : d();
  }, trigger: "change" }, userList: { required: true, validator: (i, t, d) => {
    t.length ? d() : d(new Error("请选择负责人"));
  }, trigger: "change" }, changeDate: { required: true, message: "请选择变更日期", trigger: "blur" }, payType: { required: true, message: "请选择支付方式", trigger: "change" } }, E = O, { visible: I, handleClose: S } = ce({ emit: E, props: p });
  K(() => I.value, (i) => {
    i && (p.auditStatus || U());
  }, { deep: true, immediate: true });
  function U(i) {
    g.value && g.value.resetFields(), i && Object.keys(i).length > 0 ? l.value = i : l.value = JSON.parse(JSON.stringify(C)), g.value && Q(() => {
      g.value.clearValidate();
    }), me(g, l);
  }
  const w = X(() => p.detailInfo.contractAmount && l.value.changeMoney ? p.detailInfo.contractAmount + l.value.changeMoney : void 0);
  async function B() {
    if (!await g.value.validate()) return;
    l.value.projectId = p.projectId, l.value.attachmentIds = l.value.attachments ? l.value.attachments.map((d) => d.id) : void 0, l.value.changeAmount = w, l.value.contractAmount = p.detailInfo.contractAmount;
    const t = { type: ge.VARIATION_ORDER.V, ...l.value };
    try {
      await he(t), R({ title: "提交成功", type: "success" }), E("success"), S();
    } catch (d) {
      console.log("变更签证失败", d);
    }
  }
  const J = (i) => (!i || !i.trim()) && i !== 0 ? "必填" : i.length > 200 ? "长度在 1 到 200 个字符" : true;
  async function N(i) {
    try {
      const t = i === y.PASS.V ? "通过" : "驳回", d = await ae.prompt("请输入审核说明", t, { confirmButtonText: "确定", cancelButtonText: "取消", inputType: "textarea", inputValidator: J, type: "warning" }), v = { auditStatus: i, id: p.detailInfo.id, remark: d.value };
      await ve(v), R({ title: "提交成功", type: "success" });
    } catch (t) {
      console.log("审核", t);
    } finally {
      S();
    }
  }
  return (i, t) => {
    const d = ne, v = A("common-button"), f = le, P = oe, q = ie, _ = se, $ = A("common-select"), G = ue, W = A("common-dialog"), H = Y("show-thousand");
    return n(), m(W, { "append-to-body": "", modelValue: a(I), "onUpdate:modelValue": t[8] || (t[8] = (o) => te(I) ? I.value = o : null), top: "10vh", width: "600px", "before-close": a(S), title: "变更签证", center: false, "close-on-click-modal": false }, { title: s(() => [x("div", be, [t[13] || (t[13] = x("span", { class: "title-left" }, "变更签证", -1)), e.auditStatus ? (n(), m(d, { key: 0, size: "large", type: e.auditStatus == a(y).REJECT.V ? "info" : e.auditStatus == a(y).PASS.V ? "success" : "warning" }, { default: s(() => [V(r(e.auditStatus == a(y).REJECT.V ? "已驳回" : e.auditStatus == a(y).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : k("", true), x("span", Ie, [e.auditStatus ? (n(), u(T, { key: 0 }, [e.auditStatus == a(y).AUDITING.V && e.showType === "audit" ? (n(), m(v, { key: 0, size: "default", type: "info", onClick: t[0] || (t[0] = (o) => N(a(y).REJECT.V)) }, { default: s(() => t[9] || (t[9] = [V("驳回")])), _: 1, __: [9] })) : k("", true), e.auditStatus == a(y).AUDITING.V && e.showType === "audit" ? (n(), m(v, { key: 1, size: "default", type: "success", onClick: t[1] || (t[1] = (o) => N(a(y).PASS.V)) }, { default: s(() => t[10] || (t[10] = [V("通过")])), _: 1, __: [10] })) : k("", true)], 64)) : (n(), m(v, { key: 1, type: "primary", size: "default", onClick: B }, { default: s(() => t[11] || (t[11] = [V("提交")])), _: 1, __: [11] })), c(v, { size: "default", onClick: a(S) }, { default: s(() => t[12] || (t[12] = [V("关闭")])), _: 1, __: [12] }, 8, ["onClick"])])])]), default: s(() => [c(G, { ref_key: "formRef", ref: g, model: l.value, rules: F, size: "default", "label-width": "150px" }, { default: s(() => [c(f, { label: "合同编号", prop: "serialNumber" }, { default: s(() => [e.auditStatus ? (n(), u(T, { key: 1 }, [e.detailInfo.project ? (n(), u("span", Te, r(a(M)(e.detailInfo.project)), 1)) : k("", true)], 64)) : (n(), u("span", Se, r(a(M)(e.detailInfo)), 1))]), _: 1 }), c(f, { label: "合同金额", prop: "serialNumber" }, { default: s(() => [e.auditStatus ? (n(), u("span", De, r(a(b)(e.detailInfo.contractAmount, a(h).contract)), 1)) : (n(), u("span", we, r(a(b)(e.detailInfo.contractAmount, a(h).contract)), 1))]), _: 1 }), c(f, { label: "签证金额", prop: "changeMoney" }, { default: s(() => [e.auditStatus ? (n(), u("span", { key: 1, class: ee(e.detailInfo.contractAmount > e.detailInfo.changeAmount ? "tip-red" : "tip-green") }, r(a(b)(e.detailInfo.changeAmount - e.detailInfo.contractAmount, a(h).contract)), 3)) : Z((n(), m(P, { key: 0, modelValue: l.value.changeMoney, "onUpdate:modelValue": t[2] || (t[2] = (o) => l.value.changeMoney = o), max: 9999999999, min: 0, step: 1e4, precision: a(h).contract, "controls-position": "right", placeholder: "签证金额(元)", style: { width: "320px" } }, null, 8, ["modelValue", "precision"])), [[H]])]), _: 1 }), c(f, { label: "变更后合同金额(元)", prop: "newAmount" }, { default: s(() => [e.auditStatus ? (n(), u("span", xe, r(a(b)(e.detailInfo.changeAmount, a(h).contract)), 1)) : (n(), u("span", Ae, r(w.value ? a(b)(w.value, a(h).contract) : ""), 1))]), _: 1 }), c(f, { label: "日期", prop: "changeDate" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ce, r(e.detailInfo.changeDate ? a(fe)(e.detailInfo.changeDate, "{y}-{m}-{d}") : "-"), 1)) : (n(), m(q, { key: 0, modelValue: l.value.changeDate, "onUpdate:modelValue": t[3] || (t[3] = (o) => l.value.changeDate = o), type: "date", "value-format": "x", placeholder: "日期", style: { width: "320px" }, disabledDate: (o) => o.getTime() < (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3 }, null, 8, ["modelValue", "disabledDate"]))]), _: 1 }), c(f, { label: "签证人", prop: "userList" }, { default: s(() => [e.auditStatus ? (n(true), u(T, { key: 1 }, L(e.detailInfo.leaderList, (o) => (n(), u("span", { key: o.id }, r(o.name), 1))), 128)) : (n(), m(a(Ve), { key: 0, modelValue: l.value.userList, "onUpdate:modelValue": t[4] || (t[4] = (o) => l.value.userList = o), multiple: "", filterable: "", clearable: "", "show-all-levels": "", placeholder: "签证人", style: { width: "320px" }, noDisabledVal: e.memberList }, null, 8, ["modelValue", "noDisabledVal"]))]), _: 1 }), c(f, { label: "原因描述", prop: "changeDesc" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ee, r(e.detailInfo.changeDesc), 1)) : (n(), m(_, { key: 0, modelValue: l.value.changeDesc, "onUpdate:modelValue": t[5] || (t[5] = (o) => l.value.changeDesc = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "请填写原因描述", style: { width: "320px" }, maxlength: 200 }, null, 8, ["modelValue"]))]), _: 1 }), c(f, { label: "付款方式", prop: "payType" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ne, r(e.detailInfo.payType ? a(z).VL[e.detailInfo.payType] : ""), 1)) : (n(), m($, { key: 0, modelValue: l.value.payType, "onUpdate:modelValue": t[6] || (t[6] = (o) => l.value.payType = o), options: a(z).ENUM, type: "enum", size: "default", placeholder: "付款方式", style: { width: "250px" } }, null, 8, ["modelValue", "options"]))]), _: 1 }), c(f, { label: "附件" }, { default: s(() => [e.auditStatus ? k("", true) : (n(), m(a(ke), { key: 0, ref_key: "uploadRef", ref: j, files: l.value.attachments, "onUpdate:files": t[7] || (t[7] = (o) => l.value.attachments = o), "file-classify": a(ye).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"])), e.auditStatus && e.detailInfo.attachmentList && e.detailInfo.attachmentList.length > 0 ? (n(true), u(T, { key: 1 }, L(e.detailInfo.attachmentList, (o) => (n(), u("div", { key: o.id }, [V(r(o.name) + " ", 1), c(pe, { params: { id: o.id } }, null, 8, ["params"])]))), 128)) : k("", true)]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ue = de(Le, [["__scopeId", "data-v-18ec1dcc"]]);
export {
  Ue as default
};
