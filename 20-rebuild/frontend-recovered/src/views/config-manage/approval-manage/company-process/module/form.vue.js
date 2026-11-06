import { ref as g } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as I } from "vue";
import { createBlock as V } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as c } from "vue";
import { ElMessage as j } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElInput as J } from "element-plus";
import { ElDivider as P } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElTag as W } from "element-plus";
import { ElTooltip as X } from "element-plus";
import { ElForm as Y } from "element-plus";
import { _ as Z, ao as ee, o as te, cw as f, cx as le, cv as ae, cy as N, aw as oe } from "../../../../../shared/runtime.js";
const se = { class: "table-header" }, ne = { style: { "padding-bottom": "10px" } }, de = { class: "add-row-box" }, re = { style: { display: "inline-block" } }, ie = { __name: "form", setup(pe) {
  const k = g(), U = g(), v = g([]), C = { type: void 0, userIds: [], userId: void 0 }, r = g([{ ...C }]), T = { id: void 0, type: void 0, approvalCode: void 0, approveInfoName: void 0, applicantIds: [], list: [] }, z = (n, e) => {
    var t;
    return e != null && e.type ? (e == null ? void 0 : e.type) === f.NONE.V ? !!e.userId : e.userIds instanceof Array && ((t = e == null ? void 0 : e.userIds) == null ? void 0 : t.length) > 1 : false;
  }, R = { applicantIds: [{ required: true, message: "发起人", trigger: "blur", type: "array" }], type: [{ required: true, message: "审批类型", trigger: "change" }], approveInfoName: [{ required: true, message: "审批名称", trigger: "blur" }] }, w = { type: [{ required: true, message: "请选择审批类型", trigger: "blur", type: "number" }], approval: [{ validator: z, message: "请选择审批人", trigger: "blur" }] }, { CRUD: E, crud: i, form: d } = ee(T, k), { tableValidate: O, wrongCellMask: H } = oe({ rules: w }), { maxHeight: M } = te({ clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 150 });
  E.HOOK.afterToEdit = (n, e) => {
    r.value = (e.approvers || []).map((t) => {
      var m, p, _;
      return t.userId = void 0, t.userIds = [], t.type === f.NONE.V ? t.userId = (p = (m = t == null ? void 0 : t.users) == null ? void 0 : m[0]) == null ? void 0 : p.userId : t.userIds = (_ = t == null ? void 0 : t.users) == null ? void 0 : _.map((h) => h.userId), t;
    });
  }, E.HOOK.beforeSubmit = async () => {
    const n = r.value, { validResult: e } = O(n);
    if (!e) return false;
    i.form.list = n.filter((t) => t.type).map((t) => ({ type: t.type, approverIds: t.type === f.NONE.V ? [t.userId] : t.userIds }));
  };
  function A(n) {
    r.value.splice(n, 1);
  }
  function D() {
    if (r.value.length > 19) {
      j({ message: "最多只能添加20条审批流程", type: "warning" });
      return;
    }
    r.value.push({ ...C });
  }
  F();
  async function F() {
    try {
      const n = await le() || [];
      n.map((e) => {
        e.showName = ae.VL[e.id];
      }), v.value = n;
    } catch (n) {
      console.log("error", n);
    }
  }
  function $(n) {
    const e = v.value.find((t) => t.id === n);
    d.approvalCode = e == null ? void 0 : e.name;
  }
  return (n, e) => {
    const t = b("common-button"), m = b("common-select"), p = G, _ = J, h = P, y = Q, q = b("common-table"), B = W, S = X, K = Y, L = b("common-drawer");
    return I(), V(L, { "append-to-body": "", "before-close": o(i).cancelCU, visible: o(i).status.cu > 0, title: o(i).status.title, size: "40%" }, { titleRight: s(() => [a(t, { loading: o(i).status.cu === 2, type: "primary", size: "default", onClick: o(i).submitCU }, { default: s(() => e[4] || (e[4] = [x("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: s(() => [a(K, { ref_key: "formRef", ref: k, model: o(d), rules: R, size: "default", "label-width": "80px" }, { default: s(() => [c("div", se, [a(p, { label: "审批类型", prop: "type" }, { default: s(() => [a(m, { modelValue: o(d).type, "onUpdate:modelValue": e[0] || (e[0] = (l) => o(d).type = l), options: v.value, type: "other", dataStructure: { key: "id", label: "showName", value: "id" }, size: "default", placeholder: "选择审批类型", onChange: $, style: { width: "320px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(p, { label: "审批名称", prop: "approveInfoName" }, { default: s(() => [a(_, { modelValue: o(d).approveInfoName, "onUpdate:modelValue": e[1] || (e[1] = (l) => o(d).approveInfoName = l), modelModifiers: { trim: true }, type: "text", maxlength: "30", size: "default", placeholder: "审批名称", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), a(p, { label: "发起人", prop: "applicantIds" }, { default: s(() => [a(N, { modelValue: o(d).applicantIds, "onUpdate:modelValue": e[2] || (e[2] = (l) => o(d).applicantIds = l), filterNotDdUser: true, multiple: "", filterable: "", clearable: "", "show-all-levels": "", placeholder: "选择发起人", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), c("div", ne, [a(h, null, { default: s(() => e[5] || (e[5] = [c("span", { class: "title" }, "审批流程", -1)])), _: 1, __: [5] })])]), a(q, { ref_key: "detailRef", ref: U, border: "", data: r.value, "max-height": o(M), style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": o(H) }, { default: s(() => [a(y, { label: "序号", type: "index", align: "center", width: "55" }), a(y, { key: "type", prop: "type", label: "审批类型", align: "center", "min-width": "100" }, { default: s((l) => [a(m, { modelValue: l.row.type, "onUpdate:modelValue": (u) => l.row.type = u, options: o(f).ENUM, type: "enum", size: "default", placeholder: "选择抄送节点", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), a(y, { key: "approval", prop: "approval", label: "审批人", align: "left", "min-width": "160" }, { default: s((l) => [l.row.type === o(f).NONE.V ? (I(), V(N, { key: 0, modelValue: l.row.userId, "onUpdate:modelValue": (u) => l.row.userId = u, disabled: !l.row.type, filterNotDdUser: true, size: "default", clearable: "", "show-all-levels": "", style: { width: "100%" }, placeholder: `${l.row.type ? "选择一个审批人" : "先选择审批类型"}` }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])) : (I(), V(N, { key: 1, modelValue: l.row.userIds, "onUpdate:modelValue": (u) => l.row.userIds = u, disabled: !l.row.type, filterNotDdUser: true, multiple: "", size: "default", clearable: "", "show-all-levels": "", style: { width: "100%" }, placeholder: `${l.row.type ? "至少选择两个审批人" : "先选择审批类型"}` }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"]))]), _: 1 }), a(y, { label: "操作", width: "80", align: "center" }, { default: s((l) => [a(t, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (u) => A(l.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), c("div", de, [a(t, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: e[3] || (e[3] = (l) => D()) }, { default: s(() => e[6] || (e[6] = [x("继续添加")])), _: 1, __: [6] }), a(S, { effect: "light", content: `审批流程添加规则：

          1、审批类型为单签时，只能设置一个审批人；

          2、审批类型为会签、或签时，最少要设置两个审批人。
`, placement: "top" }, { default: s(() => [c("div", re, [a(B, { size: "large", type: "info" }, { default: s(() => e[7] || (e[7] = [x("审批流程添加规则")])), _: 1, __: [7] })])]), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ce = Z(ie, [["__scopeId", "data-v-58bc4904"]]);
export {
  ce as default
};
