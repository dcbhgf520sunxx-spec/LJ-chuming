import { ref as b } from "vue";
import { inject as U } from "vue";
import { ElMessage as q } from "element-plus";
import { resolveComponent as C } from "vue";
import { openBlock as r } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { createTextVNode as F } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as u } from "vue";
import { createElementVNode as V } from "vue";
import { nextTick as te } from "vue";
import { ElTableColumn as oe } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElInputNumber as le } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElForm as ie } from "element-plus";
import { _ as ce, t as re, ao as de, g8 as ue, o as se, iv as s, fK as S, i as H, bV as me, ia as fe } from "../../../../../../shared/runtime.js";
const pe = { key: 1 }, ye = { key: 1 }, ge = { key: 1 }, _e = { key: 1 }, he = { key: 1 }, ke = { key: 1 }, we = { key: 1 }, be = { class: "add-row-box" }, Ae = { __name: "form", props: { currentRow: { type: Object, default: () => {
} }, existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 } }, setup(B) {
  const { decimalPrecision: I } = re(), M = b(), j = b(), z = { projectId: void 0, list: [] }, A = B, { CRUD: O, crud: k, form: p } = de(z, M), y = U("contractInfo"), D = U("bankList"), R = U("totalAmount"), g = b(0), w = ue(["payment_reason"]), P = { key: "id", label: "depositBank", value: "id" }, { maxHeight: $ } = se({ wrapperBox: ".collectionAddForm", paginate: true, extraHeight: 40 }), v = b(), E = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ validator: (t, o) => !!H(t), message: "请选择收款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: v.value === s.CASH, message: "请选择收款银行", trigger: "change" }], collectionBankAccount: [{ required: true, message: "请输入银行卡号", trigger: "change" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, N = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, L = b([s.PUBLIC_TRANSFER, s.ACCEPTANCE_DRAFT, s.TRANSFER_CHECK, s.PRIVATE_TRANSFER, s.CASH, s.OTHER]);
  function K({ row: t, column: o }) {
    if (!t) return;
    const d = v.value === s.CASH.V ? N : E;
    let l = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (l = S(o.property, d[o.property], t)), l && (t.verify[o.property] = true)), l ? "" : "mask-td";
  }
  function W(t) {
    p.list.splice(t, 1);
  }
  function G() {
    p.list.push({ collectionAmount: void 0, collectionBankAccount: void 0, collectionBankAccountId: void 0, collectionDate: void 0, collectionDepositBank: void 0, collectionMode: void 0, collectionReason: void 0, branchCompanyName: y.value.branchCompanyName || void 0, collectionUnitId: y.value.branchCompanyId || void 0, paymentBankAccount: y.value.customerBankCode || void 0, paymentDepositBank: y.value.customerBankName || void 0, paymentUnit: y.value.purchaser || void 0, contractWasteId: y.value.contractWasteId, isModify: true });
  }
  function J(t) {
    if (g.value = 0, A.currentRow.settlementAmount && (p.list.map((o) => {
      o.collectionAmount && (g.value += o.collectionAmount);
    }), g.value > A.currentRow.settlementAmount - R.value)) {
      const o = t.collectionAmount - (g.value - (A.currentRow.settlementAmount - R.value));
      te(() => {
        t.collectionAmount = o || 0, g.value = 0, p.list.map((d) => {
          d.collectionAmount && (g.value += d.collectionAmount);
        });
      });
    }
  }
  function Q(t) {
    if (t.collectionBankAccountId) {
      const o = D.value.find((d) => d.id === t.collectionBankAccountId);
      t.collectionDepositBank = o.depositBank, t.collectionBankAccount = o.account;
    } else t.collectionDepositBank = void 0, t.collectionBankAccount = void 0;
  }
  function X(t) {
    v.value = t.collectionMode;
  }
  return O.HOOK.beforeValidateCU = (t, o) => {
    if (t.form.list.length <= 0) return q({ message: "请添加收款明细", type: "error" }), false;
    const d = v.value === s.CASH.V ? N : E;
    let l = true;
    if (t.form.list.map((_) => {
      _.verify = {};
      for (const h in d) _.verify[h] = S(h, d[h], _), _.verify[h] || (l = false);
    }), !l) return q.error("请填写表格中标红数据"), false;
    t.form.projectId = A.projectId;
  }, (t, o) => {
    const d = C("common-button"), l = oe, _ = ne, h = le, x = C("common-select"), T = ae, Y = C("common-table"), Z = ie, ee = C("common-drawer");
    return r(), m(ee, { "before-close": n(k).cancelCU, "close-on-click-modal": false, title: n(k).status.title, visible: n(k).status.cu > 0, "wrapper-closable": false, "append-to-body": "", size: "100%" }, { titleRight: a(() => [i(d, { loading: n(k).status.cu === 2, size: "default", type: "primary", onClick: n(k).submitCU }, { default: a(() => o[1] || (o[1] = [F("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: a(() => [i(Z, { ref_key: "formRef", ref: M, model: n(p), "label-width": "140px", size: "default" }, { default: a(() => [i(Y, { ref_key: "detailRef", ref: j, "cell-class-name": K, data: n(p).list, "max-height": n($), showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: a(() => [i(l, { align: "center", label: "序号", type: "index", width: "55" }), i(l, { key: "collectionDate", align: "center", label: "*收款日期", prop: "collectionDate", width: "160" }, { default: a((e) => [e.row.isModify ? (r(), m(_, { key: 0, modelValue: e.row.collectionDate, "onUpdate:modelValue": (c) => e.row.collectionDate = c, placeholder: "选择日期", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", pe, u(e.row.collectionDate ? t.parseTime(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), i(l, { key: "collectionAmount2", align: "center", class: "money-column", label: "*收款金额", "min-width": "170", prop: "collectionAmount2" }, { default: a(() => [i(l, { key: "collectionAmount", align: "center", label: "金额", "min-width": "85", prop: "collectionAmount" }, { default: a((e) => [e.row.isModify ? (r(), m(h, { key: e.row.dataIndex ? e.row.dataIndex : e.row.id, modelValue: e.row.collectionAmount, "onUpdate:modelValue": (c) => e.row.collectionAmount = c, modelModifiers: { number: true }, max: B.currentRow.settlementAmount ? B.currentRow.settlementAmount - n(R) : 9999999999, min: -9999999999, precision: n(I).contract, step: 100, "controls-position": "right", placeholder: "收款金额(元)", onChange: (c) => J(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (r(), f("div", ye, u(n(H)(e.row.collectionAmount) ? n(me)(e.row.collectionAmount, n(I).contract) : "-"), 1))]), _: 1 }), i(l, { key: "collectionAmount1", "show-overflow-tooltip": true, align: "center", label: "大写", "min-width": "85", prop: "collectionAmount1" }, { default: a((e) => [V("div", null, u(e.row.collectionAmount ? n(fe)(e.row.collectionAmount) : ""), 1)]), _: 1 })]), _: 1 }), i(l, { key: "collectionReason", align: "center", label: "*收款事由", prop: "collectionReason", width: "120" }, { default: a((e) => [e.row.isModify ? (r(), m(x, { key: 0, modelValue: e.row.collectionReason, "onUpdate:modelValue": (c) => e.row.collectionReason = c, options: n(w).payment_reason, clearable: "", placeholder: "收款事由", size: "default", style: { width: "100%" }, type: "dict" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (r(), f("div", ge, u(e.row.collectionReason && n(w) && n(w).label && n(w).label.payment_reason ? n(w).label.payment_reason[e.row.collectionReason] : ""), 1))]), _: 1 }), i(l, { key: "collectionMode", align: "center", label: "*收款方式", prop: "collectionMode", width: "110" }, { default: a((e) => [e.row.isModify ? (r(), m(x, { key: 0, modelValue: e.row.collectionMode, "onUpdate:modelValue": (c) => e.row.collectionMode = c, options: L.value, placeholder: "收款方式", size: "default", style: { width: "100%" }, type: "enum", onChange: (c) => X(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (r(), f("div", _e, u(e.row.collectionMode ? n(s).VL[e.row.collectionMode] : ""), 1))]), _: 1 }), i(l, { key: "branchCompanyName", "show-overflow-tooltip": true, align: "center", label: "*收款单位", "min-width": "120", prop: "branchCompanyName" }, { default: a((e) => [V("div", null, u(e.row.branchCompanyName), 1)]), _: 1 }), i(l, { key: "collectionBankAccountId", "show-overflow-tooltip": true, align: "center", label: "*收款银行", "min-width": "120", prop: "collectionBankAccountId" }, { default: a((e) => [e.row.isModify ? (r(), m(x, { key: 0, modelValue: e.row.collectionBankAccountId, "onUpdate:modelValue": (c) => e.row.collectionBankAccountId = c, dataStructure: P, options: n(D), clearable: "", placeholder: "收款银行", size: "default", style: { width: "100%" }, type: "other", onChange: (c) => Q(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (r(), f("div", he, u(e.row.collectionDepositBank), 1))]), _: 1 }), i(l, { key: "collectionBankAccount", "show-overflow-tooltip": true, align: "center", label: "银行卡号", "min-width": "120", prop: "collectionBankAccount" }, { default: a((e) => [e.row.isModify ? (r(), m(T, { key: 0, modelValue: e.row.collectionBankAccount, "onUpdate:modelValue": (c) => e.row.collectionBankAccount = c, modelModifiers: { trim: true }, maxlength: "50", placeholder: "银行卡号", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", ke, u(e.row.collectionBankAccount), 1))]), _: 1 }), i(l, { key: "paymentUnit", "show-overflow-tooltip": true, align: "center", label: "*付款单位", "min-width": "120", prop: "paymentUnit" }, { default: a((e) => [V("div", null, u(e.row.paymentUnit), 1)]), _: 1 }), i(l, { key: "remark", "show-overflow-tooltip": true, align: "center", label: "备注", "min-width": "90", prop: "remark" }, { default: a((e) => [e.row.isModify ? (r(), m(T, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (c) => e.row.remark = c, modelModifiers: { trim: true }, maxlength: "200", placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", we, u(e.row.remark), 1))]), _: 1 }), i(l, { align: "center", label: "操作" }, { default: a((e) => [i(d, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => W(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), V("div", be, [i(d, { icon: "el-icon-circle-plus", size: "default", style: { "margin-right": "15px" }, type: "warning", onClick: o[0] || (o[0] = (e) => G()) }, { default: a(() => o[2] || (o[2] = [F(" 继续添加 ")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Be = ce(Ae, [["__scopeId", "data-v-c5a369fa"]]);
export {
  Be as default
};
