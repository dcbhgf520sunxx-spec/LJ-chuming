import { ref as D } from "vue";
import { watch as K } from "vue";
import { nextTick as Q } from "vue";
import { computed as X } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as n } from "vue";
import { createBlock as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as T } from "vue";
import { unref as a } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as w } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as Z } from "vue";
import { normalizeClass as ee } from "vue";
import { renderList as M } from "vue";
import { isRef as te } from "vue";
import { ElNotification as R } from "element-plus";
import { ElMessageBox as ae } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElFormItem as le } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { ElForm as ue } from "element-plus";
import { _ as de, t as re, u as ce, bC as me, c3 as g, z as F, bV as I, i as U, p as fe, S as ye, L as ge, ir as he, iu as pe, it as ve } from "../../../shared/runtime.js";
import Ve from "./components/user-dept-cascader.vue.js";
import { _ as ke } from "../../../modules/UploadBtn-b4cfb47a.js";
const Ie = { class: "dialog-title" }, Se = { style: { position: "absolute", right: "20px" } }, be = { key: 0 }, we = { key: 0 }, Ce = { key: 0 }, Ae = { key: 1 }, De = { key: 1 }, Te = { key: 0 }, xe = { key: 1 }, Ee = { key: 1 }, Ne = { key: 1, class: "detail-break" }, Le = { __name: "money-form", props: { projectId: [Number, String], auditStatus: [Number, String], modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, memberList: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(e, { emit: j }) {
  const { decimalPrecision: p } = re(), f = e, x = { id: void 0, projectId: "", changeMoney: void 0, changeAmount: void 0, changeContent: void 0, changeDate: "", userList: [], changeDesc: void 0, attachments: void 0, attachmentIds: void 0 }, l = D(JSON.parse(JSON.stringify(x))), h = D(), z = D(), B = { changeMoney: { required: true, validator: (i, t, d) => {
    U(t) ? t === 0 ? d(new Error("变更金额不能等于0")) : t === -f.detailInfo.contractAmount ? d(new Error("变更金额要大于-" + f.detailInfo.contractAmount)) : d() : d(new Error("请填写变更金额"));
  }, trigger: "change" }, userList: { required: true, validator: (i, t, d) => {
    t.length ? d() : d(new Error("请选择负责人"));
  }, trigger: "change" }, changeDate: { required: true, message: "请选择变更日期", trigger: "blur" } }, C = j, { visible: S, handleClose: b } = ce({ emit: C, props: f });
  K(() => S.value, (i) => {
    i && (f.auditStatus || O());
  }, { deep: true, immediate: true });
  function O(i) {
    h.value && h.value.resetFields(), i && Object.keys(i).length > 0 ? l.value = i : l.value = JSON.parse(JSON.stringify(x)), h.value && Q(() => {
      h.value.clearValidate();
    }), me(h, l);
  }
  const A = X(() => f.detailInfo.contractAmount && l.value.changeMoney ? f.detailInfo.contractAmount + l.value.changeMoney : void 0);
  async function J() {
    try {
      if (!await h.value.validate()) return;
      l.value.projectId = f.projectId, l.value.attachmentIds = l.value.attachments ? l.value.attachments.map((d) => d.id) : void 0, l.value.changeAmount = A, l.value.contractAmount = f.detailInfo.contractAmount;
      const t = { type: he.ENUM.CONTRACT_AMOUNT.V, ...l.value };
      await pe(t), R({ title: "提交成功", type: "success" }), C("success"), b();
    } catch (i) {
      console.log("金额变更失败", i);
    }
  }
  const P = (i) => (!i || !i.trim()) && i !== 0 ? "必填" : i.length > 200 ? "长度在 1 到 200 个字符" : true;
  async function E(i) {
    try {
      const t = i === g.PASS.V ? "通过" : "驳回", d = await ae.prompt("请输入审核说明", t, { confirmButtonText: "确定", cancelButtonText: "取消", inputType: "textarea", inputValidator: P, type: "warning" }), v = { auditStatus: i, id: f.detailInfo.id, remark: d.value };
      await ve(v), R({ title: "提交成功", type: "success" }), C("success"), b();
    } catch (t) {
      console.log("审核", t);
    }
  }
  return (i, t) => {
    const d = ne, v = L("common-button"), y = le, N = oe, q = ie, $ = se, G = ue, W = L("common-dialog"), _ = Y("show-thousand");
    return n(), m(W, { "append-to-body": "", modelValue: a(S), "onUpdate:modelValue": t[8] || (t[8] = (o) => te(S) ? S.value = o : null), top: "10vh", width: "600px", "before-close": a(b), title: "合同金额变更", center: false, "close-on-click-modal": false }, { title: s(() => [T("div", Ie, [t[13] || (t[13] = T("span", { class: "title-left" }, "合同金额变更", -1)), e.auditStatus ? (n(), m(d, { key: 0, size: "large", type: e.auditStatus == a(g).REJECT.V ? "info" : e.auditStatus == a(g).PASS.V ? "success" : "warning" }, { default: s(() => [V(r(e.auditStatus == a(g).REJECT.V ? "已驳回" : e.auditStatus == a(g).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : k("", true), T("span", Se, [e.auditStatus ? (n(), u(w, { key: 0 }, [e.auditStatus == a(g).AUDITING.V && e.showType === "audit" ? (n(), m(v, { key: 0, size: "default", type: "info", onClick: t[0] || (t[0] = (o) => E(a(g).REJECT.V)) }, { default: s(() => t[9] || (t[9] = [V("驳回")])), _: 1, __: [9] })) : k("", true), e.auditStatus == a(g).AUDITING.V && e.showType === "audit" ? (n(), m(v, { key: 1, size: "default", type: "success", onClick: t[1] || (t[1] = (o) => E(a(g).PASS.V)) }, { default: s(() => t[10] || (t[10] = [V("通过")])), _: 1, __: [10] })) : k("", true)], 64)) : (n(), m(v, { key: 1, type: "primary", size: "default", onClick: J }, { default: s(() => t[11] || (t[11] = [V("提交")])), _: 1, __: [11] })), c(v, { size: "default", onClick: a(b) }, { default: s(() => t[12] || (t[12] = [V("关闭")])), _: 1, __: [12] }, 8, ["onClick"])])])]), default: s(() => [c(G, { ref_key: "formRef", ref: h, model: l.value, rules: B, size: "default", "label-width": "150px" }, { default: s(() => [c(y, { label: "项目", prop: "serialNumber" }, { default: s(() => [e.auditStatus ? (n(), u(w, { key: 1 }, [e.detailInfo.project ? (n(), u("span", we, r(a(F)(e.detailInfo.project)), 1)) : k("", true)], 64)) : (n(), u("span", be, r(a(F)(e.detailInfo)), 1))]), _: 1 }), c(y, { label: "合同金额", prop: "serialNumber" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ae, r(a(I)(e.detailInfo.contractAmount, a(p).contract)), 1)) : (n(), u("span", Ce, r(a(I)(e.detailInfo.contractAmount, a(p).contract)), 1))]), _: 1 }), c(y, { label: "变更内容", prop: "changeContent" }, { default: s(() => [e.auditStatus ? (n(), u("span", De, r(e.detailInfo.changeContent), 1)) : (n(), m(N, { key: 0, modelValue: l.value.changeContent, "onUpdate:modelValue": t[2] || (t[2] = (o) => l.value.changeContent = o), modelModifiers: { trim: true }, placeholder: "变更内容", maxlength: 50, style: { width: "320px" } }, null, 8, ["modelValue"]))]), _: 1 }), c(y, { label: "变更金额(可增减)", prop: "changeMoney" }, { default: s(() => [e.auditStatus ? (n(), u("span", { key: 1, class: ee(e.detailInfo.contractAmount > e.detailInfo.changeAmount ? "tip-red" : "tip-green") }, r(a(I)(e.detailInfo.changeAmount - e.detailInfo.contractAmount, a(p).contract)), 3)) : Z((n(), m(q, { key: 0, modelValue: l.value.changeMoney, "onUpdate:modelValue": t[3] || (t[3] = (o) => l.value.changeMoney = o), max: 9999999999, min: -e.detailInfo.contractAmount, step: 100, precision: a(p).contract, "controls-position": "right", placeholder: "变更金额(元)", style: { width: "320px" } }, null, 8, ["modelValue", "min", "precision"])), [[_]])]), _: 1 }), c(y, { label: "变更后合同金额(元)", prop: "newAmount" }, { default: s(() => [e.auditStatus ? (n(), u("span", xe, r(a(I)(e.detailInfo.changeAmount, a(p).contract)), 1)) : (n(), u("span", Te, r(a(U)(A.value) ? a(I)(A.value, a(p).contract) : ""), 1))]), _: 1 }), c(y, { label: "变更日期", prop: "changeDate" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ee, r(e.detailInfo.changeDate ? a(fe)(e.detailInfo.changeDate, "{y}-{m}-{d}") : "-"), 1)) : (n(), m($, { key: 0, modelValue: l.value.changeDate, "onUpdate:modelValue": t[4] || (t[4] = (o) => l.value.changeDate = o), type: "date", "value-format": "x", placeholder: "变更日期", style: { width: "320px" }, disabledDate: (o) => o.getTime() < (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3 }, null, 8, ["modelValue", "disabledDate"]))]), _: 1 }), c(y, { label: "负责人", prop: "userList" }, { default: s(() => [e.auditStatus ? (n(true), u(w, { key: 1 }, M(e.detailInfo.leaderList, (o, H) => (n(), u("span", { key: o.id }, r(H !== 0 ? "," + o.name : o.name), 1))), 128)) : (n(), m(a(Ve), { key: 0, modelValue: l.value.userList, "onUpdate:modelValue": t[5] || (t[5] = (o) => l.value.userList = o), multiple: "", filterable: "", clearable: "", "show-all-levels": "", placeholder: "负责人", noDisabledVal: e.memberList, style: { width: "320px" } }, null, 8, ["modelValue", "noDisabledVal"]))]), _: 1 }), c(y, { label: "描述", prop: "changeDesc" }, { default: s(() => [e.auditStatus ? (n(), u("span", Ne, r(e.detailInfo.changeDesc), 1)) : (n(), m(N, { key: 0, modelValue: l.value.changeDesc, "onUpdate:modelValue": t[6] || (t[6] = (o) => l.value.changeDesc = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "请填写描述", style: { width: "320px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"]))]), _: 1 }), c(y, { label: "附件" }, { default: s(() => [e.auditStatus ? k("", true) : (n(), m(a(ke), { key: 0, ref_key: "uploadRef", ref: z, files: l.value.attachments, "onUpdate:files": t[7] || (t[7] = (o) => l.value.attachments = o), "file-classify": a(ye).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"])), e.auditStatus && e.detailInfo.attachmentList && e.detailInfo.attachmentList.length > 0 ? (n(true), u(w, { key: 1 }, M(e.detailInfo.attachmentList, (o) => (n(), u("div", { key: o.id }, [V(r(o.name) + " ", 1), c(ge, { params: { id: o.id } }, null, 8, ["params"])]))), 128)) : k("", true)]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Be = de(Le, [["__scopeId", "data-v-141f70cf"]]);
export {
  Be as default
};
