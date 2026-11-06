import { ref as b } from "vue";
import { inject as I } from "vue";
import { ElMessage as F } from "element-plus";
import { resolveComponent as R } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as i } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createVNode as r } from "vue";
import { unref as o } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as S } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as ie } from "vue";
import { createElementVNode as D } from "vue";
import { nextTick as ce } from "vue";
import { ElTag as re } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElDatePicker as de } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElForm as fe } from "element-plus";
import { _ as pe, t as ye, ao as ge, g8 as _e, o as ke, iv as f, fK as z, bV as E, i as H, ia as he } from "../../../../../../shared/runtime.js";
const we = { key: 1 }, Ae = { key: 1 }, ve = { key: 1 }, be = { key: 1 }, Ve = { key: 1 }, Be = { key: 1 }, Re = { key: 1 }, Ce = { key: 1 }, Ue = { class: "add-row-box" }, xe = { __name: "form", props: { currentRow: { type: Object, default: () => {
} }, existInvoiceNo: { type: Array, default: () => {
} }, projectId: { type: [String, Number], default: void 0 } }, setup(h) {
  const { decimalPrecision: V } = ye(), N = b(), L = b(), O = { projectId: void 0, list: [] }, w = h, { CRUD: P, crud: A, form: g } = ge(O, N), s = I("contractInfo"), T = I("bankList"), U = I("totalAmount"), _ = b(0), v = _e(["payment_reason"]), $ = { key: "id", label: "depositBank", value: "id" }, { maxHeight: K } = ke({ wrapperBox: ".collectionAddForm", paginate: true, extraHeight: 40 }), B = b(), q = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ validator: (t, l) => !!H(t), message: "请选择收款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: B.value === f.CASH, message: "请选择收款银行", trigger: "change" }], collectionBankAccount: [{ required: true, message: "请输入银行卡号", trigger: "change" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, j = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, G = b([f.PUBLIC_TRANSFER, f.ACCEPTANCE_DRAFT, f.TRANSFER_CHECK, f.PRIVATE_TRANSFER, f.CASH, f.OTHER]);
  function J({ row: t, column: l }) {
    if (!t) return;
    const u = B.value === f.CASH.V ? j : q;
    let p = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[l.property] === false && (p = z(l.property, u[l.property], t)), p && (t.verify[l.property] = true)), p ? "" : "mask-td";
  }
  function Q(t) {
    g.list.splice(t, 1);
  }
  function W() {
    g.list.push({ collectionAmount: void 0, collectionBankAccount: void 0, collectionBankAccountId: void 0, collectionDate: void 0, collectionDepositBank: void 0, collectionMode: void 0, collectionReason: void 0, collectionUnit: s.value.companyBankAccountList && s.value.companyBankAccountList.length > 0 ? s.value.companyBankAccountList[0].companyName : void 0, collectionUnitId: s.value.companyBankAccountList && s.value.companyBankAccountList.length > 0 ? s.value.companyBankAccountList[0].companyId : void 0, paymentBankAccount: s.value.customerBankCode || void 0, paymentDepositBank: s.value.customerBankName || void 0, paymentUnit: s.value.customerUnit || void 0, projectId: w.projectId, isModify: true });
  }
  function X(t) {
    if (_.value = 0, w.currentRow.settlementAmount && (g.list.map((l) => {
      l.collectionAmount && (_.value += l.collectionAmount);
    }), _.value > w.currentRow.settlementAmount - U.value)) {
      const l = t.collectionAmount - (_.value - (w.currentRow.settlementAmount - U.value));
      ce(() => {
        t.collectionAmount = l || 0, _.value = 0, g.list.map((u) => {
          u.collectionAmount && (_.value += u.collectionAmount);
        });
      });
    }
  }
  function Y(t) {
    if (t.collectionBankAccountId) {
      const l = T.value.find((u) => u.id === t.collectionBankAccountId);
      t.collectionDepositBank = l.depositBank, t.collectionBankAccount = l.account;
    } else t.collectionDepositBank = void 0, t.collectionBankAccount = void 0;
  }
  function Z(t) {
    B.value = t.collectionMode;
  }
  return P.HOOK.beforeValidateCU = (t, l) => {
    if (t.form.list.length <= 0) return F({ message: "请添加收款明细", type: "error" }), false;
    const u = B.value === f.CASH.V ? j : q;
    let p = true;
    if (t.form.list.map((c) => {
      c.verify = {};
      for (const k in u) c.verify[k] = z(k, u[k], c), c.verify[k] || (p = false);
    }), !p) return F.error("请填写表格中标红数据"), false;
    t.form.projectId = w.projectId;
  }, (t, l) => {
    const u = R("common-button"), p = re, c = ue, k = de, ee = se, x = R("common-select"), M = me, te = R("common-table"), oe = fe, ne = R("common-drawer"), le = ae("show-thousand");
    return i(), m(ne, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(A).cancelCU, visible: o(A).status.cu > 0, title: o(A).status.title, "wrapper-closable": false, size: "100%" }, { titleRight: n(() => [r(u, { loading: o(A).status.cu === 2, type: "primary", size: "default", onClick: o(A).submitCU }, { default: n(() => l[0] || (l[0] = [C("确认")])), _: 1, __: [0] }, 8, ["loading", "onClick"])]), content: n(() => [o(s).contractAmount ? (i(), m(p, { key: 0, type: "success" }, { default: n(() => [C(d("合同金额:" + o(E)(o(s).contractAmount, o(V).contract)), 1)]), _: 1 })) : S("", true), h.currentRow.settlementAmount ? (i(), m(p, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: n(() => [C(d("结算金额:" + o(E)(h.currentRow.settlementAmount, o(V).contract)), 1)]), _: 1 })) : S("", true), r(oe, { ref_key: "formRef", ref: N, model: o(g), size: "default", "label-width": "140px" }, { default: n(() => [r(te, { ref_key: "detailRef", ref: L, border: "", data: o(g).list, "max-height": o(K), style: { width: "100%", "margin-top": "10px" }, class: "table-form", "cell-class-name": J, "return-source-data": "", showEmptySymbol: false }, { default: n(() => [r(c, { label: "序号", type: "index", align: "center", width: "55" }), r(c, { key: "collectionDate", prop: "collectionDate", label: "*收款日期", align: "center", width: "160" }, { default: n((e) => [e.row.isModify ? (i(), m(k, { key: 0, modelValue: e.row.collectionDate, "onUpdate:modelValue": (a) => e.row.collectionDate = a, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), y("div", we, d(e.row.collectionDate ? t.parseTime(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), r(c, { key: "collectionAmount2", prop: "collectionAmount2", label: "*收款金额", align: "center", "min-width": "170", class: "money-column" }, { default: n(() => [r(c, { key: "collectionAmount", prop: "collectionAmount", label: "金额", align: "center", "min-width": "85" }, { default: n((e) => [e.row.isModify ? ie((i(), m(ee, { modelValue: e.row.collectionAmount, "onUpdate:modelValue": (a) => e.row.collectionAmount = a, modelModifiers: { number: true }, min: -9999999999, max: h.currentRow.settlementAmount ? h.currentRow.settlementAmount - o(U) : 9999999999, step: 100, precision: o(V).contract, placeholder: "收款金额(元)", "controls-position": "right", key: e.row.dataIndex ? e.row.dataIndex : e.row.id, onChange: (a) => X(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[le]]) : (i(), y("div", Ae, d(o(H)(e.row.collectionAmount) ? o(E)(e.row.collectionAmount, o(V).contract) : "-"), 1))]), _: 1 }), r(c, { key: "collectionAmount1", prop: "collectionAmount1", label: "大写", align: "center", "min-width": "85", "show-overflow-tooltip": true }, { default: n((e) => [D("div", null, d(e.row.collectionAmount ? o(he)(e.row.collectionAmount) : ""), 1)]), _: 1 })]), _: 1 }), r(c, { key: "collectionReason", prop: "collectionReason", label: "*收款事由", align: "center", width: "120" }, { default: n((e) => [e.row.isModify ? (i(), m(x, { key: 0, modelValue: e.row.collectionReason, "onUpdate:modelValue": (a) => e.row.collectionReason = a, options: o(v).payment_reason, type: "dict", size: "default", clearable: "", placeholder: "收款事由", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (i(), y("div", ve, d(e.row.collectionReason && o(v) && o(v).label && o(v).label.payment_reason ? o(v).label.payment_reason[e.row.collectionReason] : ""), 1))]), _: 1 }), r(c, { key: "collectionMode", prop: "collectionMode", label: "*收款方式", align: "center", width: "110" }, { default: n((e) => [e.row.isModify ? (i(), m(x, { key: 0, modelValue: e.row.collectionMode, "onUpdate:modelValue": (a) => e.row.collectionMode = a, options: G.value, type: "enum", size: "default", placeholder: "收款方式", style: { width: "100%" }, onChange: (a) => Z(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (i(), y("div", be, d(e.row.collectionMode ? o(f).VL[e.row.collectionMode] : ""), 1))]), _: 1 }), r(c, { key: "collectionUnit", prop: "collectionUnit", label: "*收款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n((e) => [D("div", null, d(e.row.collectionUnit), 1)]), _: 1 }), r(c, { key: "collectionBankAccountId", prop: "collectionBankAccountId", "show-overflow-tooltip": true, label: "*收款银行", align: "center", "min-width": "120" }, { default: n((e) => [e.row.isModify ? (i(), m(x, { key: 0, modelValue: e.row.collectionBankAccountId, "onUpdate:modelValue": (a) => e.row.collectionBankAccountId = a, options: o(T), type: "other", dataStructure: $, size: "default", clearable: "", placeholder: "收款银行", style: { width: "100%" }, onChange: (a) => Y(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (i(), y("div", Ve, d(e.row.collectionDepositBank), 1))]), _: 1 }), r(c, { key: "collectionBankAccount", prop: "collectionBankAccount", "show-overflow-tooltip": true, label: "银行卡号", align: "center", "min-width": "120" }, { default: n((e) => [e.row.isModify ? (i(), m(M, { key: 0, modelValue: e.row.collectionBankAccount, "onUpdate:modelValue": (a) => e.row.collectionBankAccount = a, modelModifiers: { trim: true }, placeholder: "银行卡号", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), y("div", Be, d(e.row.collectionBankAccount), 1))]), _: 1 }), r(c, { key: "paymentUnit", prop: "paymentUnit", label: "*付款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n((e) => [e.row.isModify ? (i(), m(M, { key: 0, modelValue: e.row.paymentUnit, "onUpdate:modelValue": (a) => e.row.paymentUnit = a, modelModifiers: { trim: true }, placeholder: "付款单位", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), y("div", Re, d(e.row.paymentUnit), 1))]), _: 1 }), r(c, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "90", "show-overflow-tooltip": true }, { default: n((e) => [e.row.isModify ? (i(), m(M, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (a) => e.row.remark = a, modelModifiers: { trim: true }, placeholder: "备注", type: "textarea", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), y("div", Ce, d(e.row.remark), 1))]), _: 1 }), r(c, { label: "操作", align: "center" }, { default: n((e) => [r(u, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (a) => Q(e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), D("div", Ue, [r(u, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: W }, { default: n(() => l[1] || (l[1] = [C(" 继续添加 ")])), _: 1, __: [1] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ee = pe(xe, [["__scopeId", "data-v-50766fad"]]);
export {
  Ee as default
};
