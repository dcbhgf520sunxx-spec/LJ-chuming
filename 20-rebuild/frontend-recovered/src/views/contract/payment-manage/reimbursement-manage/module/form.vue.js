import { ref as f } from "vue";
import { watch as ee } from "vue";
import { computed as le } from "vue";
import { ElMessage as D } from "element-plus";
import { resolveComponent as x } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as L } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { unref as n } from "vue";
import { createTextVNode as w } from "vue";
import { createElementVNode as y } from "vue";
import { createElementBlock as R } from "vue";
import { toDisplayString as te } from "vue";
import { createCommentVNode as v } from "vue";
import { ElFormItem as oe } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElDivider as ie } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElForm as re } from "element-plus";
import { _ as pe, t as ue, ao as me, ia as ce, bN as fe, bb as ye, cy as E, bD as V, aw as ge, i as xe } from "../../../../../shared/runtime.js";
import { b as _e } from "../../../../../modules/collection-9275714a.js";
import be from "./expense.vue.js";
import "../../../../../modules/expense-config-93f15b94.js";
const he = { class: "form-row", style: { display: "flex" } }, we = { key: 0, style: { size: "12px" } }, ve = { class: "form-row", style: { display: "flex" } }, Ve = { class: "form-row", style: { display: "flex" } }, Ie = { class: "form-row", style: { display: "flex" } }, Ue = { key: 0 }, Ce = { class: "add-row-box" }, Ne = { __name: "form", setup(Ae) {
  const { decimalPrecision: b } = ue(), I = f(), U = f(), C = f(), B = f(), $ = { id: void 0, applyAmount: void 0, applyDate: void 0, applyDepartId: void 0, applyUserId: void 0, collectionBankAccount: void 0, collectionDepositBank: void 0, collectionUserId: void 0, detailList: [], projectId: void 0, remark: void 0 }, { CRUD: N, crud: u, form: l } = me($, I), m = f({}), z = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "blur" }], collectionUserId: [{ required: true, message: "请选择收款人", trigger: "change" }], applyUserId: [{ required: true, message: "请选择申请人", trigger: "change" }], applyDate: [{ required: true, message: "请选择申请日期", trigger: "change" }] }, j = { choseId: [{ required: true, message: "请选择报销种类", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "change", type: "number" }] }, { tableValidate: q, wrongCellMask: F } = ge({ rules: j }), g = f([]);
  ee(() => l.projectId, (t) => {
    t ? O(t) : m.value = {};
  }, { deep: true, immediate: true });
  function P() {
    const t = C.value.getNodeInfo();
    xe(t) ? l.collectionUserName = t.label : l.collectionUserName = void 0;
  }
  function M() {
    if (l.applyUserId) {
      const t = U.value.getNodeInfo();
      l.applyDepartId = t.parentDeptId, l.applyDepartName = t.parentDeptName, l.applyUserName = t.label, l.collectionUserId || (l.collectionUserId = l.applyUserId);
    } else l.applyDepartId = void 0, l.applyDepartName = void 0, l.applyUserName = void 0;
  }
  function A(t, a) {
    if (t && (l.detailList[a].invoiceAmount = t), l.detailList.length > 0) {
      let r = 0;
      l.detailList.forEach((d) => {
        d.applyAmount > 0 && (r += d.applyAmount);
      }), l.applyAmount = r;
    } else l.applyAmount = void 0;
  }
  const k = le(() => l.applyAmount ? ce(l.applyAmount) : "");
  async function O(t) {
    let a = {};
    try {
      a = await _e({ projectId: t });
    } catch (r) {
      console.log("获取合同信息", r);
    } finally {
      m.value = a, m.value.businessTypeName = m.value.businessType ? fe.VL[m.value.businessType] : "";
    }
  }
  function S(t) {
    t && (t.type === 1 ? (l.detailList[t.dataIndex].expenseTypeId = t.id, l.detailList[t.dataIndex].dictionaryId = void 0) : (l.detailList[t.dataIndex].expenseTypeId = t.parentId, l.detailList[t.dataIndex].dictionaryId = t.id));
  }
  function T(t) {
    l.detailList[t].taxRate && l.detailList[t].invoiceAmount ? l.detailList[t].inputTax = (l.detailList[t].invoiceAmount * l.detailList[t].taxRate / 100).toFixed(b.value.contract) : l.detailList[t].inputTax = void 0;
  }
  function H(t) {
    l.detailList.splice(t, 1), A();
  }
  function K(t, a) {
    if (t.invoiceNo) {
      const r = g.value.find((d) => d.index === a);
      g.value.findIndex((d) => d.invoiceNo === t.invoiceNo) > -1 ? (D({ message: "发票号已存在，请重新填写", type: "error" }), t.invoiceNo = void 0, r && (r.invoiceNo = void 0)) : r ? r.invoiceNo = t.invoiceNo : g.value.push({ invoiceNo: t.invoiceNo, index: a });
    }
  }
  function Y() {
    u.form.detailList.push({ applyAmount: void 0, choseId: void 0, dictionaryId: void 0, expenseTypeId: void 0, inputTax: void 0, invoiceAmount: void 0, invoiceNo: void 0, invoiceType: void 0, taxRate: void 0, dataIndex: u.form.detailList.length });
  }
  return N.HOOK.beforeValidateCU = (t, a) => {
    if (t.form.detailList.length <= 0) return D({ message: "请先填写报销明细", type: "error" }), false;
    const { validResult: r, dealList: d } = q(t.form.detailList);
    if (r) t.form.detailList = d;
    else return r;
  }, N.HOOK.afterAddSuccess = () => {
    g.value = [];
  }, (t, a) => {
    const r = x("common-button"), d = oe, c = ae, G = ne, J = ie, p = de, h = se, Q = x("common-select"), W = x("common-table"), X = re, Z = x("common-drawer");
    return _(), L(Z, { "append-to-body": "", "close-on-click-modal": false, "before-close": n(u).cancelCU, visible: n(u).status.cu > 0, title: n(u).status.title, "wrapper-closable": false, size: "1200px" }, { titleRight: i(() => [o(r, { loading: n(u).status.cu === 2, type: "primary", size: "default", onClick: n(u).submitCU }, { default: i(() => a[10] || (a[10] = [w("确认")])), _: 1, __: [10] }, 8, ["loading", "onClick"])]), content: i(() => [o(X, { ref_key: "formRef", ref: I, model: n(l), rules: z, size: "default", "label-width": "140px" }, { default: i(() => [y("div", he, [o(d, { label: "项目", prop: "projectId" }, { default: i(() => [o(n(ye), { modelValue: n(l).projectId, "onUpdate:modelValue": a[0] || (a[0] = (e) => n(l).projectId = e), style: { width: "320px" }, class: "filter-item" }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "申请金额(元)", prop: "applyAmount" }, { default: i(() => [o(c, { modelValue: n(l).applyAmount, "onUpdate:modelValue": a[1] || (a[1] = (e) => n(l).applyAmount = e), type: "text", placeholder: "申请金额", style: { width: "320px" }, disabled: "" }, null, 8, ["modelValue"]), k.value ? (_(), R("div", we, te(k.value), 1)) : v("", true)]), _: 1 })]), y("div", ve, [o(d, { label: "业务类型", prop: "businessType" }, { default: i(() => [o(c, { modelValue: m.value.businessTypeName, "onUpdate:modelValue": a[2] || (a[2] = (e) => m.value.businessTypeName = e), type: "text", placeholder: "业务类型", style: { width: "320px" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "申请人", prop: "applyUserId" }, { default: i(() => [o(E, { ref_key: "applyRef", ref: U, modelValue: n(l).applyUserId, "onUpdate:modelValue": a[3] || (a[3] = (e) => n(l).applyUserId = e), filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "申请人", onChange: M }, null, 8, ["modelValue"])]), _: 1 })]), y("div", Ve, [o(d, { label: "收款人", prop: "collectionUserId" }, { default: i(() => [o(E, { modelValue: n(l).collectionUserId, "onUpdate:modelValue": a[4] || (a[4] = (e) => n(l).collectionUserId = e), ref_key: "collectionRef", ref: C, filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "收款人", onChange: P }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "申请日期", prop: "applyDate" }, { default: i(() => [o(G, { modelValue: n(l).applyDate, "onUpdate:modelValue": a[5] || (a[5] = (e) => n(l).applyDate = e), type: "date", "value-format": "x", placeholder: "申请日期", style: { width: "320px" }, disabledDate: (e) => e.getTime() > (/* @__PURE__ */ new Date()).getTime() }, null, 8, ["modelValue", "disabledDate"])]), _: 1 })]), y("div", Ie, [o(d, { label: "收款开户行", prop: "collectionDepositBank" }, { default: i(() => [o(c, { modelValue: n(l).collectionDepositBank, "onUpdate:modelValue": a[6] || (a[6] = (e) => n(l).collectionDepositBank = e), type: "text", placeholder: "收款开户行", style: { width: "320px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), o(d, { label: "收款账号", prop: "collectionBankAccount" }, { default: i(() => [o(c, { modelValue: n(l).collectionBankAccount, "onUpdate:modelValue": a[7] || (a[7] = (e) => n(l).collectionBankAccount = e), type: "text", placeholder: "收款账号", style: { width: "320px" }, maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 })]), o(d, { label: "备注", prop: "remark" }, { default: i(() => [o(c, { modelValue: n(l).remark, "onUpdate:modelValue": a[8] || (a[8] = (e) => n(l).remark = e), type: "textarea", autosize: { minRows: 6, maxRows: 8 }, maxlength: 200, "show-word-limit": "", placeholder: "可填写备注", style: { "max-width": "500px" } }, null, 8, ["modelValue"])]), _: 1 }), o(J, null, { default: i(() => a[11] || (a[11] = [y("span", { class: "title" }, "报销明细", -1)])), _: 1, __: [11] }), o(W, { ref_key: "detailRef", ref: B, border: "", data: n(l).detailList, "max-height": 300, style: { width: "100%" }, class: "table-form", "cell-class-name": n(F) }, { default: i(() => [o(p, { label: "序号", type: "index", align: "center", width: "55" }), o(p, { prop: "choseId", label: "报销种类", align: "center", "min-width": "250" }, { default: i((e) => [o(n(be), { ref: "expenseRef", modelValue: e.row.choseId, "onUpdate:modelValue": (s) => e.row.choseId = s, onChange: S, "data-index": e.$index }, null, 8, ["modelValue", "onUpdate:modelValue", "data-index"])]), _: 1 }), o(p, { prop: "applyAmount", label: "申请金额（元）", align: "center", "min-width": "120" }, { default: i((e) => [o(h, { modelValue: e.row.applyAmount, "onUpdate:modelValue": (s) => e.row.applyAmount = s, min: 1, max: 99999999999, step: 1e4, precision: n(b).contract, size: "default", "controls-position": "right", placeholder: "申请金额", style: { width: "100%", "max-width": "200px" }, onChange: (s) => A(e.row.applyAmount, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), o(p, { prop: "invoiceType", label: "发票类型", align: "center", "min-width": "160" }, { default: i((e) => [o(Q, { modelValue: e.row.invoiceType, "onUpdate:modelValue": (s) => e.row.invoiceType = s, options: n(V).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "发票类型", style: { width: "130px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), o(p, { prop: "invoiceNo", label: "发票号码", align: "center", "min-width": "150" }, { default: i((e) => [o(c, { modelValue: e.row.invoiceNo, "onUpdate:modelValue": (s) => e.row.invoiceNo = s, type: "text", placeholder: "发票号码", style: { width: "100%" }, onChange: (s) => K(e.row, e.$index), maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), o(p, { prop: "invoiceAmount", label: "发票面额（元）", align: "center", "min-width": "120" }, { default: i((e) => [o(h, { modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (s) => e.row.invoiceAmount = s, min: e.row.applyAmount ? e.row.applyAmount : 1, max: 99999999999, step: 1e4, precision: n(b).contract, size: "default", "controls-position": "right", placeholder: "发票面额", style: { width: "100%", "max-width": "200px" }, onChange: (s) => T(e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])]), _: 1 }), o(p, { prop: "taxRate", label: "税率", align: "center", "min-width": "80" }, { default: i((e) => [e.row.invoiceType === n(V).ENUM.SPECIAL.V ? (_(), R("div", Ue, [o(h, { modelValue: e.row.taxRate, "onUpdate:modelValue": (s) => e.row.taxRate = s, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "70px", "text-align": "center" }, placeholder: "0-100", onChange: (s) => T(e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"]), a[12] || (a[12] = w("% "))])) : v("", true)]), _: 1 }), o(p, { prop: "inputTax", label: "进项税额(元)", align: "center", "min-width": "130" }, { default: i((e) => [e.row.invoiceType === n(V).ENUM.SPECIAL.V ? (_(), L(c, { key: 0, modelValue: e.row.inputTax, "onUpdate:modelValue": (s) => e.row.inputTax = s, type: "text", placeholder: "先输入税率", style: { width: "100px" }, disabled: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : v("", true)]), _: 1 }), o(p, { label: "操作", align: "center" }, { default: i((e) => [o(r, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (s) => H(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), y("div", Ce, [o(r, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: a[9] || (a[9] = (e) => Y()) }, { default: i(() => a[13] || (a[13] = [w("继续添加")])), _: 1, __: [13] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ee = pe(Ne, [["__scopeId", "data-v-5adb752f"]]);
export {
  Ee as default
};
