import { ref as h } from "vue";
import { provide as H } from "vue";
import { watch as K } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as O } from "vue";
import { unref as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as k } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as v } from "vue";
import { Fragment as W } from "vue";
import { nextTick as be } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTag as Ce } from "element-plus";
import { ElTableColumn as Ve } from "element-plus";
import { ElDatePicker as Ie } from "element-plus";
import { ElInputNumber as xe } from "element-plus";
import { ElInput as Se } from "element-plus";
import { ElPopconfirm as Re } from "element-plus";
import { vLoading as Ne } from "element-plus";
import { c as P, b as Ue, d as Be, e as Me } from "../../../../../../modules/collection-9275714a.js";
import { _ as De, t as Te, g8 as Ee, x as Oe, o as Pe, iv as _, c3 as I, bV as q, p as qe, i as Z, ia as je, G as j, P as ze, fK as ee } from "../../../../../../shared/runtime.js";
import { k as Fe } from "../../../../../../modules/contract-9b18cc88.js";
import He from "./form.vue.js";
const $e = { class: "app-container" }, Le = { class: "clearfix" }, Qe = { style: { float: "left" } }, Ge = { style: { float: "right" } }, Je = { key: 1 }, Ke = { key: 1 }, Ye = { key: 1 }, We = { key: 1 }, Xe = { key: 1 }, Ze = { key: 1 }, et = { key: 1 }, tt = { key: 1 }, ot = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, moneySum: { type: Object, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(A, { emit: te }) {
  const b = Fe.collection, { decimalPrecision: x } = Te(), oe = { add: true, edit: false, del: false, download: false }, S = A, $ = h(), N = Ee(["payment_reason"]), U = h({}), L = h({}), B = h([]), ne = { key: "id", label: "depositBank", value: "id" }, g = h(0), le = te, z = h();
  H("bankList", B), H("contractInfo", U), H("totalAmount", g);
  const { crud: u, CRUD: M } = Oe({ title: "收款填报", sort: [], permission: { ...b }, optShow: { ...oe }, crudApi: { ...P }, invisibleColumns: ["haveCollectionAmount", "collectionMode", "collectionReason", "collectionDepositBank", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, $), Q = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: true, message: "请选择收款银行", trigger: "change" }], collectionBankAccount: [{ required: true, message: "请输入银行卡号", trigger: "change" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, G = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] };
  function ae({ row: t, column: o }) {
    if (!t) return;
    const a = z.value === _.CASH.V ? G : Q;
    let p = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (p = ee(o.property, a[o.property], t)), p && (t.verify[o.property] = true)), p ? "" : "mask-td";
  }
  const { maxHeight: ie } = Pe({ wrapperBox: ".collection", paginate: true, extraHeight: 40 }), re = h([_.PUBLIC_TRANSFER, _.ACCEPTANCE_DRAFT, _.TRANSFER_CHECK, _.PRIVATE_TRANSFER, _.CASH, _.OTHER]), ce = h([I.AUDITING, I.PASS]);
  K(() => S.projectId, (t) => {
    B.value = [], U.value = {}, t && de(t), u.toQuery();
  }, { deep: true, immediate: true }), K(() => S.visibleValue, (t) => {
    t && u.toQuery();
  }, { deep: true, immediate: true });
  function ue(t) {
    if (S.currentRow.settlementAmount && (g.value = 0, u.data.map((o) => {
      o.collectionAmount && (g.value += o.collectionAmount);
    }), g.value > S.currentRow.settlementAmount)) {
      const o = t.collectionAmount - (g.value - S.currentRow.settlementAmount);
      be(() => {
        t.collectionAmount = o || 0, g.value = 0, u.data.map((a) => {
          a.collectionAmount && (g.value += a.collectionAmount);
        });
      });
    }
  }
  async function de(t) {
    let o = {};
    try {
      o = await Ue({ projectId: t }), se(o.companyBankAccountList[0].companyId);
    } catch (a) {
      console.log("获取合同信息", a);
    } finally {
      U.value = o;
    }
  }
  async function se(t) {
    try {
      const { content: o } = await Be(t);
      B.value = o;
    } catch (o) {
      console.log("获取银行账号", o);
    }
  }
  function me(t) {
    if (t.collectionBankAccountId) {
      const o = B.value.find((a) => a.id === t.collectionBankAccountId);
      t.collectionDepositBank = o.depositBank, t.collectionBankAccount = o.account;
    } else t.collectionDepositBank = void 0, t.collectionBankAccount = void 0;
  }
  async function pe(t) {
    try {
      await Me({ id: t.id, auditStatus: I.PASS.V }), u.notify("审核成功", M.NOTIFICATION_TYPE.SUCCESS), u.toQuery(), le("success");
    } catch (o) {
      console.log("审核失败", o);
    }
  }
  function ye(t) {
    L.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function fe(t) {
    try {
      await P.del(t.id), u.notify("删除成功", M.NOTIFICATION_TYPE.SUCCESS), u.toQuery();
    } catch (o) {
      console.log("删除失败", o);
    }
  }
  function ge(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(L.value)));
    else {
      const o = u.data.findIndex((a) => a.dataIndex === t.dataIndex);
      u.data.splice(o, 1);
    }
  }
  async function _e(t) {
    if (t.collectionAmount === 0) {
      X.error("收款金额必须大于0");
      return;
    }
    const o = z.value === _.CASH.V ? G : Q;
    let a = true;
    t.verify = {};
    for (const y in o) t.verify[y] = ee(y, o[y], t), t.verify[y] || (a = false);
    if (!a) {
      X.error("请填写表格中标红数据");
      return;
    }
    const p = t.id ? "修改" : "新增";
    try {
      t.id ? await P.edit(t) : await P.add(t), u.notify(`${p}成功`, M.NOTIFICATION_TYPE.SUCCESS), u.toQuery();
    } catch (y) {
      console.log(p, y);
    }
  }
  function we(t) {
    const { columns: o, data: a } = t, p = [];
    return o.forEach((y, C) => {
      var d;
      if (C === 0) {
        p[C] = "查询合计";
        return;
      }
      if (y.property === "collectionAmount") {
        const E = a.map((w) => w.collectionAmount);
        E.every((w) => isNaN(w)) || (p[C] = E.reduce((w, R) => {
          const D = Number(R);
          return isNaN(D) ? w : w + R;
        }, 0)), p[C] = (d = p[C]) == null ? void 0 : d.toFixed(x.value.contract);
      }
    }), p;
  }
  function he(t) {
    z.value = t.collectionMode;
  }
  return M.HOOK.beforeRefresh = () => {
    u.query.projectId = S.projectId;
  }, M.HOOK.handleRefresh = (t, o) => {
    g.value = 0, o.data.content.map((a) => {
      a.projectId = a.project.id, a.collectionAmount && (g.value += a.collectionAmount);
    });
  }, (t, o) => {
    const a = T("common-button"), p = T("common-radio-button"), y = Ce, C = T("print-table"), d = Ve, E = Ie, w = xe, R = T("common-select"), D = Se, F = Re, ke = T("common-table"), J = Y("permission"), ve = Y("show-thousand"), Ae = Ne;
    return l(), f("div", $e, [V("div", Le, [V("div", Qe, [O((l(), s(a, { type: "primary", size: "default", onClick: n(u).toAdd, style: { "margin-right": "10px" } }, { default: i(() => o[1] || (o[1] = [k(" 添加 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[J, n(b).add]]), c(p, { modelValue: n(u).query.auditStatus, "onUpdate:modelValue": o[0] || (o[0] = (e) => n(u).query.auditStatus = e), options: ce.value, showOptionAll: "", size: "default", style: { float: "right" }, type: "enum", onChange: n(u).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), V("div", Ge, [U.value.contractAmount ? (l(), s(y, { key: 0, type: "success", size: "large" }, { default: i(() => [k(m("合同金额：" + n(q)(U.value.contractAmount, n(x).contract)), 1)]), _: 1 })) : v("", true), A.currentRow.settlementAmount ? (l(), s(y, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: i(() => [k(m("结算金额：" + n(q)(A.currentRow.settlementAmount, n(x).contract)), 1)]), _: 1 })) : v("", true), A.moneySum.collectionAmount ? (l(), s(y, { key: 2, type: "warning", size: "large", style: { "margin-left": "5px" } }, { default: i(() => [k(" 已收款【审核通过】：" + m(n(q)(A.moneySum.collectionAmount, n(x).contract)), 1)]), _: 1 })) : v("", true), O(c(C, { "api-key": "collectionRecord", params: n(u).query, style: { "margin-left": "5px", float: "right" }, size: "default", type: "warning" }, null, 8, ["params"]), [[J, n(u).permission.print]])])]), O((l(), s(ke, { ref_key: "tableRef", ref: $, data: n(u).data, "empty-text": n(u).emptyText, "max-height": n(ie), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "show-summary": "", "summary-method": we, "cell-class-name": ae, stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: i(() => [c(d, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), c(d, { key: "collectionDate", prop: "collectionDate", label: "收款日期", align: "center", width: "160" }, { default: i((e) => [e.row.isModify ? (l(), s(E, { key: 0, modelValue: e.row.collectionDate, "onUpdate:modelValue": (r) => e.row.collectionDate = r, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), f("div", Je, m(e.row.collectionDate ? n(qe)(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), c(d, { key: "collectionAmount2", prop: "collectionAmount2", label: "收款金额", align: "center", "min-width": "170", class: "money-column" }, { default: i(() => [c(d, { key: "collectionAmount", prop: "collectionAmount", label: "金额", align: "center", "min-width": "85" }, { default: i((e) => [e.row.isModify ? O((l(), s(w, { modelValue: e.row.collectionAmount, "onUpdate:modelValue": (r) => e.row.collectionAmount = r, modelModifiers: { number: true }, min: -9999999999, max: 9999999999, step: 100, precision: n(x).contract, placeholder: "收款金额(元)", "controls-position": "right", key: e.row.dataIndex ? e.row.dataIndex : e.row.id, onChange: (r) => ue(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])), [[ve]]) : (l(), f("div", Ke, m(n(Z)(e.row.collectionAmount) ? n(q)(e.row.collectionAmount, n(x).contract) : "-"), 1))]), _: 1 }), c(d, { key: "collectionAmount1", prop: "collectionAmount1", label: "大写", align: "center", "min-width": "85", "show-overflow-tooltip": true }, { default: i((e) => [V("div", null, m(n(Z)(e.row.collectionAmount) ? n(je)(e.row.collectionAmount) : ""), 1)]), _: 1 })]), _: 1 }), c(d, { key: "collectionReason", prop: "collectionReason", label: "收款事由", align: "center", width: "120" }, { default: i((e) => [e.row.isModify ? (l(), s(R, { key: 0, modelValue: e.row.collectionReason, "onUpdate:modelValue": (r) => e.row.collectionReason = r, options: n(N).payment_reason, type: "dict", size: "default", clearable: "", placeholder: "收款事由", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (l(), f("div", Ye, m(e.row.collectionReason && n(N) && n(N).label && n(N).label.payment_reason ? n(N).label.payment_reason[e.row.collectionReason] : ""), 1))]), _: 1 }), c(d, { key: "collectionMode", prop: "collectionMode", label: "收款方式", align: "center", width: "110" }, { default: i((e) => [e.row.isModify ? (l(), s(R, { key: 0, modelValue: e.row.collectionMode, "onUpdate:modelValue": (r) => e.row.collectionMode = r, options: re.value, type: "enum", size: "default", placeholder: "收款方式", style: { width: "100%" }, onChange: (r) => he(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (l(), f("div", We, m(e.row.collectionMode ? n(_).VL[e.row.collectionMode] : ""), 1))]), _: 1 }), c(d, { key: "collectionUnit", prop: "collectionUnit", label: "收款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: i((e) => [V("div", null, m(e.row.collectionUnit), 1)]), _: 1 }), c(d, { key: "collectionBankAccountId", prop: "collectionBankAccountId", "show-overflow-tooltip": true, label: "收款银行", align: "center", "min-width": "120" }, { default: i((e) => [e.row.isModify ? (l(), s(R, { key: 0, modelValue: e.row.collectionBankAccountId, "onUpdate:modelValue": (r) => e.row.collectionBankAccountId = r, options: B.value, type: "other", dataStructure: ne, size: "default", placeholder: "收款银行", clearable: "", style: { width: "100%" }, onChange: (r) => me(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (l(), f("div", Xe, m(e.row.collectionDepositBank), 1))]), _: 1 }), c(d, { key: "collectionBankAccount", prop: "collectionBankAccount", "show-overflow-tooltip": true, label: "银行卡号", align: "center", "min-width": "120" }, { default: i((e) => [e.row.isModify ? (l(), s(D, { key: 0, modelValue: e.row.collectionBankAccount, "onUpdate:modelValue": (r) => e.row.collectionBankAccount = r, modelModifiers: { trim: true }, placeholder: "银行卡号", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), f("div", Ze, m(e.row.collectionBankAccount), 1))]), _: 1 }), c(d, { key: "paymentUnit", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: i((e) => [e.row.isModify ? (l(), s(D, { key: 0, modelValue: e.row.paymentUnit, "onUpdate:modelValue": (r) => e.row.paymentUnit = r, modelModifiers: { trim: true }, placeholder: "付款单位", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), f("div", et, m(e.row.paymentUnit), 1))]), _: 1 }), c(d, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "90", "show-overflow-tooltip": true }, { default: i((e) => [e.row.isModify ? (l(), s(D, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (r) => e.row.remark = r, modelModifiers: { trim: true }, placeholder: "备注", type: "textarea", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), f("div", tt, m(e.row.remark), 1))]), _: 1 }), c(d, { key: "writtenByName", prop: "writtenByName", label: "办理人", align: "center", width: "100px" }, { default: i((e) => [V("div", null, m(e.row.writtenByName), 1)]), _: 1 }), c(d, { key: "auditorName", prop: "auditorName", label: "审核人", align: "center", width: "100px" }, { default: i((e) => [V("div", null, m(e.row.auditorName), 1)]), _: 1 }), n(j)([...n(b).edit, ...n(b).audit]) ? (l(), s(d, { key: 0, label: "操作", width: "190px", align: "center" }, { default: i((e) => [e.row.isModify ? (l(), f(W, { key: 1 }, [c(F, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (r) => ge(e.row, e.$index) }, { reference: i(() => [c(a, { type: "info", plain: "", size: "default" }, { default: i(() => o[4] || (o[4] = [k("取消")])), _: 1, __: [4] })]), _: 2 }, 1032, ["onConfirm"]), c(a, { type: "primary", size: "default", onClick: (r) => _e(e.row) }, { default: i(() => o[5] || (o[5] = [k("保存")])), _: 2, __: [5] }, 1032, ["onClick"])], 64)) : (l(), f(W, { key: 0 }, [e.row.auditStatus === n(I).AUDITING.V && n(j)(n(b).edit) ? (l(), s(a, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (r) => ye(e.row) }, null, 8, ["onClick"])) : v("", true), e.row.auditStatus === n(I).AUDITING.V && n(j)(n(b).del) ? (l(), s(F, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (r) => fe(e.row) }, { reference: i(() => [c(a, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : v("", true), e.row.auditStatus === n(I).AUDITING.V && n(j)(n(b).audit) ? (l(), s(F, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (r) => pe(e.row) }, { reference: i(() => [c(a, { type: "success", size: "default" }, { default: i(() => o[2] || (o[2] = [k("通过")])), _: 1, __: [2] })]), _: 2 }, 1032, ["onConfirm"])) : v("", true), e.row.auditStatus === n(I).PASS.V ? (l(), s(y, { key: 3, type: "success", class: "pass-tag" }, { default: i(() => o[3] || (o[3] = [k("已复核")])), _: 1, __: [3] })) : v("", true)], 64))]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[Ae, n(u).loading]]), c(n(He), { projectId: A.projectId, currentRow: A.currentRow }, null, 8, ["projectId", "currentRow"]), c(n(ze))]);
  };
} }, ct = De(ot, [["__scopeId", "data-v-442b2d8b"]]);
export {
  ct as default
};
