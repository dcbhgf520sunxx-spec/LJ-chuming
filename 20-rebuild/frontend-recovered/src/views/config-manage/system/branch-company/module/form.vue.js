import { ref as x } from "vue";
import { ElMessage as k } from "element-plus";
import { resolveComponent as p } from "vue";
import { openBlock as j } from "vue";
import { createBlock as S } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as h } from "vue";
import { createElementVNode as _ } from "vue";
import { ElInput as $ } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as L } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { ElCheckbox as G } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElForm as W } from "element-plus";
import { _ as X, cB as c, ao as Y, fK as E, g3 as Z, g4 as ee, eR as v } from "../../../../../shared/runtime.js";
const le = { style: { display: "inline-block" } }, te = { class: "add-row-box" }, oe = { __name: "form", setup(ae) {
  const g = x(), U = x(), w = { bankAccounts: [], enabled: c.TRUE.V, isParent: c.FALSE.V, name: void 0, remark: void 0, socialCode: void 0, shortName: void 0, sort: void 0, level: void 0 }, { CRUD: C, crud: m, form: a } = Y(w, g), N = { name: [{ required: true, message: "请输入公司名称", trigger: "blur" }], shortName: [{ required: true, message: "请输入简称", trigger: "blur" }], sort: [{ required: true, message: "请输入排序", trigger: "blur" }], level: [{ required: true, message: "请输入单位属性", trigger: "blur" }], branchAttributeEnum: [{ required: true, message: "请输入属性", trigger: "blur" }], socialCode: [{ max: 18, message: "长度不超过 18 个字符", trigger: "blur" }, { pattern: v.pattern, message: v.message }] }, y = { depositBank: [{ required: true, message: "请输入开户行", trigger: "blur" }] };
  function R({ row: s, column: e }) {
    if (!s) return;
    const u = y;
    let d = true;
    return s.verify && Object.keys(s.verify) && Object.keys(s.verify).length > 0 && (s.verify[e.property] === false && (d = E(e.property, u[e.property], s)), d && (s.verify[e.property] = true)), d ? "" : "mask-td";
  }
  function A(s) {
    a.bankAccounts.splice(s, 1);
  }
  function B() {
    a.bankAccounts.push({ account: void 0, depositBank: void 0 });
  }
  return C.HOOK.beforeValidateCU = (s, e) => {
    if (s.form.bankAccounts.length <= 0) return k({ message: "请先填写银行账号明细", type: "error" }), false;
    const u = y;
    let d = true;
    if (s.form.bankAccounts.map((r) => {
      r.verify = {};
      for (const i in u) r.verify[i] = E(i, u[i], r), r.verify[i] || (d = false);
    }), !d) return k.error("请填写表格中标红数据"), false;
  }, (s, e) => {
    const u = p("common-button"), d = $, r = D, i = K, F = L, M = H, z = G, I = p("common-radio"), V = p("common-select"), q = J, f = Q, O = p("common-table"), T = W, P = p("common-drawer");
    return j(), S(P, { "before-close": t(m).cancelCU, "close-on-click-modal": false, title: t(m).status.title, visible: t(m).status.cu > 0, "wrapper-closable": false, "append-to-body": "", size: "860px" }, { titleRight: n(() => [l(u, { loading: t(m).status.cu === 2, size: "default", type: "primary", onClick: t(m).submitCU }, { default: n(() => e[10] || (e[10] = [h("确认 ")])), _: 1, __: [10] }, 8, ["loading", "onClick"])]), content: n(() => [l(T, { ref_key: "formRef", ref: g, model: t(a), rules: N, "label-width": "140px", size: "default" }, { default: n(() => [l(r, { label: "公司名称", prop: "name" }, { default: n(() => [l(d, { modelValue: t(a).name, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(a).name = o), class: "input-underline", maxlength: "50", placeholder: "请填写名称", style: { width: "320px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "简称", prop: "shortName" }, { default: n(() => [l(d, { modelValue: t(a).shortName, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(a).shortName = o), class: "input-underline", maxlength: "50", placeholder: "请填写简称", style: { width: "320px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "社会统一信用代码", prop: "socialCode" }, { default: n(() => [l(d, { modelValue: t(a).socialCode, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(a).socialCode = o), class: "input-underline", maxlength: "18", placeholder: "请填写社会统一信用代码", style: { width: "320px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "母公司", prop: "isParent" }, { label: n(() => [l(M, { content: "只可选择一个公司为母公司，若选择新的母公司，原母公司会被取消", effect: "light", placement: "left" }, { default: n(() => [_("div", le, [e[11] || (e[11] = _("span", null, "母公司", -1)), l(F, { style: { color: "#909399" } }, { default: n(() => [l(i)]), _: 1 })])]), _: 1 })]), default: n(() => [l(z, { modelValue: t(a).isParent, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(a).isParent = o), "false-label": t(c).ENUM.FALSE.V, "true-label": t(c).ENUM.TRUE.V }, null, 8, ["modelValue", "false-label", "true-label"])]), _: 1 }), l(r, { label: "状态", prop: "enabled" }, { default: n(() => [l(I, { modelValue: t(a).enabled, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(a).enabled = o), options: t(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "单位属性", prop: "level" }, { default: n(() => [l(V, { modelValue: t(a).level, "onUpdate:modelValue": e[5] || (e[5] = (o) => t(a).level = o), options: t(Z).ENUM, class: "filter-item", clearable: "", placeholder: "选择单位属性", style: { width: "270px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "属性", prop: "branchAttributeEnum" }, { default: n(() => [l(V, { modelValue: t(a).branchAttributeEnum, "onUpdate:modelValue": e[6] || (e[6] = (o) => t(a).branchAttributeEnum = o), options: t(ee).ENUM, class: "filter-item", clearable: "", placeholder: "选择属性", style: { width: "270px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "排序", prop: "sort" }, { default: n(() => [l(q, { modelValue: t(a).sort, "onUpdate:modelValue": e[7] || (e[7] = (o) => t(a).sort = o), modelModifiers: { number: true }, max: 999, min: 1, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "备注", prop: "remark" }, { default: n(() => [l(d, { modelValue: t(a).remark, "onUpdate:modelValue": e[8] || (e[8] = (o) => t(a).remark = o), autosize: { minRows: 6, maxRows: 8 }, maxlength: "200", placeholder: "请填写备注", "show-word-limit": "", style: { "max-width": "500px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), l(O, { ref_key: "detailRef", ref: U, "cell-class-name": R, data: t(a).bankAccounts, "max-height": 300, showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%" } }, { default: n(() => [l(f, { align: "center", label: "序号", type: "index", width: "55" }), l(f, { align: "center", label: "开户行", "min-width": "270", prop: "depositBank" }, { default: n((o) => [l(d, { modelValue: o.row.depositBank, "onUpdate:modelValue": (b) => o.row.depositBank = b, maxlength: "50", placeholder: "开户行", style: { width: "260px" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(f, { align: "center", label: "账号", "min-width": "270", prop: "account" }, { default: n((o) => [l(d, { modelValue: o.row.account, "onUpdate:modelValue": (b) => o.row.account = b, maxlength: "30", placeholder: "账号", style: { width: "260px" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(f, { align: "center", label: "操作" }, { default: n((o) => [l(u, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (b) => A(o.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"]), _("div", te, [l(u, { icon: "el-icon-circle-plus", size: "default", style: { "margin-right": "15px" }, type: "warning", onClick: e[9] || (e[9] = (o) => B()) }, { default: n(() => e[12] || (e[12] = [h(" 继续添加 ")])), _: 1, __: [12] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, se = X(oe, [["__scopeId", "data-v-d9b705a7"]]);
export {
  se as default
};
