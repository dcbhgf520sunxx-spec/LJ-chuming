import { ref as w } from "vue";
import { watch as te } from "vue";
import { ElMessage as j } from "element-plus";
import { resolveComponent as V } from "vue";
import { openBlock as s } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { createTextVNode as R } from "vue";
import { createElementBlock as g } from "vue";
import { toDisplayString as m } from "vue";
import { createElementVNode as v } from "vue";
import { createCommentVNode as le } from "vue";
import { isRef as ne } from "vue";
import { ElTableColumn as ae } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { ElInputNumber as ce } from "element-plus";
import { ElInput as re } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as se, t as ue, u as me, ao as fe, g8 as pe, o as ye, iv as u, V as ge, fK as H, p as he, i as T, bV as we, ia as _e, kg as B } from "../../../../../shared/runtime.js";
import { g as ke } from "../../../../../modules/scrap-sell-e306ced6.js";
const be = { key: 1 }, Ae = { key: 1 }, ve = { key: 1 }, Ce = { key: 1 }, Ve = { key: 1 }, Re = { key: 1 }, Be = { class: "add-row-box" }, Ie = { __name: "collection", props: { visible: { type: Boolean }, detailInfo: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 } }, emits: ["update:visible"], setup(_, { emit: z }) {
  const { decimalPrecision: I } = ue(), U = w(), F = w(), O = { projectId: void 0, list: [] }, r = _, q = z, { visible: C, handleClose: x } = me({ emit: q, props: r, field: "visible" }), { CRUD: M, crud: k, form: b } = fe(O, U), h = pe(["payment_reason"]), P = { key: "account", label: "depositBank", value: "id" }, { maxHeight: L } = ye({ wrapperBox: ".collectionAddForm", paginate: true, extraHeight: 40 }), A = w(), D = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ validator: (o, l) => !!T(o), message: "请选择收款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: A.value === u.CASH, message: "请选择收款银行", trigger: "change" }], collectionBankAccount: [{ required: true, message: "请输入银行卡号", trigger: "change" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }] }, E = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }] };
  function $({ row: o, column: l }) {
    if (!o) return;
    const d = A.value === u.CASH.V ? E : D;
    let n = true;
    return o.verify && Object.keys(o.verify) && Object.keys(o.verify).length > 0 && (o.verify[l.property] === false && (n = H(l.property, d[l.property], o)), n && (o.verify[l.property] = true)), n ? "" : "mask-td";
  }
  function K(o) {
    b.list.splice(o, 1);
  }
  function W() {
    b.list.push({ collectionAmount: void 0, collectionBankAccount: void 0, collectionDate: void 0, collectionBankAccountId: void 0, collectionMode: void 0, collectionReason: void 0, branchCompanyName: (r == null ? void 0 : r.currentRow.branchCompanyName) || void 0, collectionUnitId: (r == null ? void 0 : r.currentRow.branchCompanyId) || void 0, paymentUnit: (r == null ? void 0 : r.currentRow.purchaser) || void 0, contractWasteId: r == null ? void 0 : r.currentRow.contractWasteId, isModify: true });
  }
  const G = w([]), J = w([]);
  Q();
  async function Q() {
    try {
      const { content: o } = await ke();
      J.value = o, G.value = o.map((l) => {
        const d = {};
        return d.id = l.id, d.name = l.purchaser, d;
      });
    } catch (o) {
      console.log("获取购买单位失败", o);
    }
  }
  te(() => r.currentRow, (o) => {
    if (o != null && o.id) {
      const l = ge(o);
      k.form.list = [{ ...l, isModify: true }];
    }
  }, { deep: true, immediate: true });
  function xe(o) {
  }
  function X(o) {
    if (o.collectionBankAccountId) {
      const l = r.detailInfo.bankList.find((d) => d.id === o.collectionBankAccountId);
      o.collectionDepositBank = l.depositBank, o.collectionBankAccount = l.account;
    } else o.collectionDepositBank = void 0, o.collectionBankAccount = void 0;
  }
  function Y(o) {
    A.value = o.collectionMode;
  }
  return M.HOOK.beforeValidateCU = (o, l) => {
    if (o.form.list.length <= 0) return j({ message: "请添加收款明细", type: "error" }), false;
    const d = A.value === u.CASH.V ? E : D;
    let n = true;
    if (o.form.list.map((p) => {
      p.verify = {};
      for (const y in d) p.verify[y] = H(y, d[y], p), p.verify[y] || (n = false);
    }), !n) return j.error("请填写表格中标红数据"), false;
    o.form.projectId = r.projectId, o.form.status = "collection";
  }, M.HOOK.afterSubmit = () => {
    x();
  }, (o, l) => {
    var S;
    const d = V("common-button"), n = ae, p = ie, y = ce, N = re, Z = V("common-table"), ee = de, oe = V("common-drawer");
    return s(), f(oe, { modelValue: t(C), "onUpdate:modelValue": l[0] || (l[0] = (e) => ne(C) ? C.value = e : null), "close-on-click-modal": false, "show-close": false, title: (S = _.currentRow) != null && S.id ? "修改收款填报" : "新增收款填报", "wrapper-closable": false, "append-to-body": "", size: "100%", onClose: t(k).cancelCU }, { titleRight: a(() => [i(d, { loading: t(k).status.cu === 2, size: "small", type: "primary", onClick: t(k).submitCU }, { default: a(() => l[1] || (l[1] = [R("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), i(d, { size: "small", onClick: t(x) }, { default: a(() => l[2] || (l[2] = [R("关闭")])), _: 1, __: [2] }, 8, ["onClick"])]), content: a(() => [i(ee, { ref_key: "formRef", ref: U, model: t(b), "label-width": "140px", size: "small" }, { default: a(() => [i(Z, { ref_key: "detailRef", ref: F, "cell-class-name": $, data: t(b).list, "max-height": t(L), showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: a(() => [i(n, { align: "center", label: "序号", type: "index", width: "50" }), i(n, { key: "collectionDate", align: "center", label: "*收款日期", prop: "collectionDate", width: "160" }, { default: a((e) => [e.row.isModify ? (s(), f(p, { key: 0, modelValue: e.row.collectionDate, "onUpdate:modelValue": (c) => e.row.collectionDate = c, placeholder: "选择日期", size: "small", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), g("div", be, m(e.row.collectionDate ? t(he)(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), i(n, { key: "collectionAmount2", align: "center", class: "money-column", label: "*收款金额", "min-width": "170", prop: "collectionAmount2" }, { default: a(() => [i(n, { key: "collectionAmount", align: "center", label: "金额", "min-width": "85", prop: "collectionAmount" }, { default: a((e) => [e.row.isModify ? (s(), f(y, { key: e.row.dataIndex ? e.row.dataIndex : e.row.id, modelValue: e.row.collectionAmount, "onUpdate:modelValue": (c) => e.row.collectionAmount = c, modelModifiers: { number: true }, max: 9999999999, min: -9999999999, precision: t(I).contract, step: 100, "controls-position": "right", placeholder: "收款金额(元)", onChange: (c) => (e.row, void 0) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (s(), g("div", Ae, m(t(T)(e.row.collectionAmount) ? t(we)(e.row.collectionAmount, t(I).contract) : "-"), 1))]), _: 1 }), i(n, { key: "collectionAmount1", "show-overflow-tooltip": true, align: "center", label: "大写", "min-width": "85", prop: "collectionAmount1" }, { default: a((e) => [v("div", null, m(e.row.collectionAmount ? t(_e)(e.row.collectionAmount) : ""), 1)]), _: 1 })]), _: 1 }), i(n, { key: "collectionReason", align: "center", label: "*收款事由", prop: "collectionReason", width: "120" }, { default: a((e) => [e.row.isModify ? (s(), f(B, { key: 0, modelValue: e.row.collectionReason, "onUpdate:modelValue": (c) => e.row.collectionReason = c, options: t(h).payment_reason, clearable: "", placeholder: "收款事由", size: "small", style: { width: "100%" }, type: "dict" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (s(), g("div", ve, m(e.row.collectionReason && t(h) && t(h).label && t(h).label.payment_reason ? t(h).label.payment_reason[e.row.collectionReason] : ""), 1))]), _: 1 }), i(n, { key: "collectionMode", align: "center", label: "*收款方式", prop: "collectionMode", width: "110" }, { default: a((e) => [e.row.isModify ? (s(), f(B, { key: 0, modelValue: e.row.collectionMode, "onUpdate:modelValue": (c) => e.row.collectionMode = c, options: [t(u).PUBLIC_TRANSFER, t(u).ACCEPTANCE_DRAFT, t(u).TRANSFER_CHECK, t(u).PRIVATE_TRANSFER, t(u).CASH, t(u).OTHER], placeholder: "收款方式", size: "small", style: { width: "100%" }, type: "enum", onChange: (c) => Y(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (s(), g("div", Ce, m(e.row.collectionMode ? t(u).VL[e.row.collectionMode] : ""), 1))]), _: 1 }), i(n, { key: "collectionUnitId", "show-overflow-tooltip": true, align: "center", label: "*收款单位", "min-width": "120", prop: "collectionUnitId" }, { default: a((e) => [v("div", null, m(e.row.branchCompanyName), 1)]), _: 1 }), i(n, { key: "collectionBankAccountId", "show-overflow-tooltip": true, align: "center", label: "*收款银行", "min-width": "120", prop: "collectionBankAccountId" }, { default: a((e) => [i(B, { modelValue: e.row.collectionBankAccountId, "onUpdate:modelValue": (c) => e.row.collectionBankAccountId = c, dataStructure: P, options: _.detailInfo.bankList, clearable: "", placeholder: "收款银行", size: "small", style: { width: "100%" }, type: "other", onChange: (c) => X(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), i(n, { key: "collectionBankAccount", "show-overflow-tooltip": true, align: "center", label: "银行卡号", "min-width": "120", prop: "collectionBankAccount" }, { default: a((e) => [e.row.isModify ? (s(), f(N, { key: 0, modelValue: e.row.collectionBankAccount, "onUpdate:modelValue": (c) => e.row.collectionBankAccount = c, modelModifiers: { trim: true }, maxlength: "50", placeholder: "银行卡号", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), g("div", Ve, m(e.row.collectionBankAccount), 1))]), _: 1 }), i(n, { key: "contractWasteId", "show-overflow-tooltip": true, align: "center", label: "*付款单位", "min-width": "120" }, { default: a((e) => [v("div", null, m(e.row.paymentUnit), 1)]), _: 1 }), i(n, { key: "remark", "show-overflow-tooltip": true, align: "center", label: "备注", "min-width": "90", prop: "remark" }, { default: a((e) => [e.row.isModify ? (s(), f(N, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (c) => e.row.remark = c, modelModifiers: { trim: true }, maxlength: "200", placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), g("div", Re, m(e.row.remark), 1))]), _: 1 }), i(n, { align: "center", label: "操作" }, { default: a((e) => [i(d, { icon: "el-icon-delete", size: "small", type: "danger", onClick: (c) => K(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), v("div", Be, [_.currentRow.id ? le("", true) : (s(), f(d, { key: 0, icon: "el-icon-circle-plus", size: "small", style: { "margin-right": "15px" }, type: "warning", onClick: W }, { default: a(() => l[3] || (l[3] = [R("继续添加")])), _: 1, __: [3] }))])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "title", "onClose"]);
  };
} }, Ne = se(Ie, [["__scopeId", "data-v-409eed89"]]);
export {
  Ne as default
};
