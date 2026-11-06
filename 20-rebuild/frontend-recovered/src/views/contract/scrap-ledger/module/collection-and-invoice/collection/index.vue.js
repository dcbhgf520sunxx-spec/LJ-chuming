import { ref as v } from "vue";
import { provide as $ } from "vue";
import { watch as K } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as A } from "vue";
import { withDirectives as O } from "vue";
import { unref as n } from "vue";
import { createBlock as m } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as S } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as x } from "vue";
import { Fragment as W } from "vue";
import { nextTick as Ce } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTag as Ie } from "element-plus";
import { ElTableColumn as Ve } from "element-plus";
import { ElDatePicker as Se } from "element-plus";
import { ElInputNumber as xe } from "element-plus";
import { ElInput as Re } from "element-plus";
import { ElPopconfirm as Be } from "element-plus";
import { vLoading as Ne } from "element-plus";
import { l as R, _ as Ue, t as Me, g8 as De, x as Te, c3 as I, iv as h, o as Ee, bV as Z, p as Oe, i as ee, ia as Pe, G as P, P as qe, fK as te } from "../../../../../../shared/runtime.js";
import { V as je } from "../../../../../../modules/contract-9b18cc88.js";
import ze from "./form.vue.js";
function Fe(d) {
  return R({ module: "contract", url: "contract/collection/waste", method: "get", params: d });
}
function $e(d) {
  return R({ module: "contract", url: "contract/collection/waste", method: "post", params: { projectId: d.projectId }, data: d.list });
}
function He(d) {
  return R({ module: "contract", url: "contract/collection/waste", method: "put", data: d });
}
function Le(d) {
  return R({ module: "contract", url: `contract/collection/deleteById/${d}/waste`, method: "delete" });
}
function Qe(d) {
  return R({ module: "contract", url: "contract/collection/audit/waste", method: "put", data: d });
}
function Ge(d) {
  return R({ module: "contract", url: `branchCompany/listBankAccountByCompanyId/${d}`, method: "get" });
}
const q = { get: Fe, add: $e, edit: He, del: Le };
const Je = { class: "app-container" }, Ke = { class: "clearfix" }, Ye = { style: { float: "left" } }, We = { style: { float: "right" } }, Xe = { key: 1 }, Ze = { key: 1 }, et = { key: 1 }, tt = { key: 1 }, ot = { key: 1 }, nt = { key: 1 }, lt = { key: 1 }, at = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, moneySum: { type: Object, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(d, { emit: oe }) {
  const b = je.collection, { decimalPrecision: D } = Me(), ne = { add: true, edit: false, del: false, download: false }, w = d, H = v(), B = De(["payment_reason"]), j = v({}), L = v({}), N = v([]), le = { key: "id", label: "depositBank", value: "id" }, _ = v(0), ae = oe, z = v();
  $("bankList", N), $("contractInfo", j), $("totalAmount", _);
  const { crud: c, CRUD: U } = Te({ title: "收款填报", sort: [], permission: { ...b }, optShow: { ...ne }, crudApi: { ...q }, invisibleColumns: ["haveCollectionAmount", "collectionMode", "collectionReason", "collectionDepositBank", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, H), Q = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: true, message: "请选择收款银行", trigger: "change" }], collectionBankAccount: [{ required: true, message: "请输入银行卡号", trigger: "change" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, G = { collectionDate: [{ required: true, message: "请选择收款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择收款金额", trigger: "change", type: "number" }], collectionMode: [{ required: true, message: "请选择收款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择收款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] }, ie = v([I.AUDITING, I.PASS]), ce = v([h.PUBLIC_TRANSFER, h.ACCEPTANCE_DRAFT, h.TRANSFER_CHECK, h.PRIVATE_TRANSFER, h.CASH, h.OTHER]);
  function re({ row: t, column: o }) {
    if (!t) return;
    const l = z.value === h.CASH.V ? G : Q;
    let p = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (p = te(o.property, l[o.property], t)), p && (t.verify[o.property] = true)), p ? "" : "mask-td";
  }
  const { maxHeight: ue } = Ee({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  K(() => w.currentRow, (t) => {
    console.log(t), N.value = [], j.value = {}, t && se(t.branchCompanyId), c.toQuery();
  }, { deep: true, immediate: true }), K(() => w.visibleValue, (t) => {
    t && c.toQuery();
  }, { deep: true, immediate: true });
  function de(t) {
    if (w.currentRow.settlementAmount && (_.value = 0, c.data.map((o) => {
      o.collectionAmount && (_.value += o.collectionAmount);
    }), _.value > w.currentRow.settlementAmount)) {
      const o = t.collectionAmount - (_.value - w.currentRow.settlementAmount);
      Ce(() => {
        t.collectionAmount = o || 0, _.value = 0, c.data.map((l) => {
          l.collectionAmount && (_.value += l.collectionAmount);
        });
      });
    }
  }
  async function se(t) {
    try {
      me(t);
    } catch (o) {
      console.log("获取合同信息", o);
    } finally {
      j.value = w.currentRow;
    }
  }
  async function me(t) {
    try {
      const { content: o } = await Ge(t);
      N.value = o;
    } catch (o) {
      console.log("获取银行账号", o);
    }
  }
  function pe(t) {
    if (t.collectionBankAccountId) {
      const o = N.value.find((l) => l.id === t.collectionBankAccountId);
      t.collectionDepositBank = o.depositBank, t.collectionBankAccount = o.account;
    } else t.collectionDepositBank = void 0, t.collectionBankAccount = void 0;
  }
  async function fe(t) {
    try {
      await Qe({ id: t.id, auditStatus: I.PASS.V }), c.notify("审核成功", U.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), ae("success");
    } catch (o) {
      console.log("审核失败", o);
    }
  }
  function ye(t) {
    L.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function ge(t) {
    try {
      await q.del(t.id), c.notify("删除成功", U.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (o) {
      console.log("删除失败", o);
    }
  }
  function _e(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(L.value)));
    else {
      const o = c.data.findIndex((l) => l.dataIndex === t.dataIndex);
      c.data.splice(o, 1);
    }
  }
  async function he(t) {
    if (t.collectionAmount === 0) {
      X.error("收款金额必须大于0");
      return;
    }
    const o = z.value === h.CASH.V ? G : Q;
    let l = true;
    t.verify = {};
    for (const y in o) t.verify[y] = te(y, o[y], t), t.verify[y] || (l = false);
    if (!l) {
      X.error("请填写表格中标红数据");
      return;
    }
    const p = t.id ? "修改" : "新增";
    try {
      t.id ? await q.edit(t) : await q.add(t), c.notify(`${p}成功`, U.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (y) {
      console.log(p, y);
    }
  }
  function we(t) {
    const { columns: o, data: l } = t, p = [];
    return o.forEach((y, C) => {
      var s;
      if (C === 0) {
        p[C] = "查询合计";
        return;
      }
      if (y.property === "collectionAmount") {
        const T = l.map((k) => k.collectionAmount);
        T.every((k) => isNaN(k)) || (p[C] = T.reduce((k, V) => {
          const E = Number(V);
          return isNaN(E) ? k : k + V;
        }, 0)), p[C] = (s = p[C]) == null ? void 0 : s.toFixed(D.value.contract);
      }
    }), p;
  }
  function ke(t) {
    z.value = t.collectionMode;
  }
  return U.HOOK.beforeRefresh = () => {
    c.query.branchCompanyId = w.currentRow.branchCompanyId, c.query.contractWasteId = w.currentRow.contractWasteId;
  }, U.HOOK.handleRefresh = (t, o) => {
    _.value = 0, o.data.content.map((l) => {
      l.projectId = l.project.id, l.collectionAmount && (_.value += l.collectionAmount);
    });
  }, (t, o) => {
    const l = M("common-button"), p = M("common-radio-button"), y = Ie, C = M("print-table"), s = Ve, T = Se, k = xe, V = M("common-select"), E = Re, F = Be, ve = M("common-table"), J = Y("permission"), Ae = Y("show-thousand"), be = Ne;
    return a(), g("div", Je, [A("div", Ke, [A("div", Ye, [O((a(), m(l, { type: "primary", size: "default", onClick: n(c).toAdd, style: { "margin-right": "10px" } }, { default: i(() => o[1] || (o[1] = [S(" 添加 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[J, n(b).add]]), r(p, { modelValue: n(c).query.auditStatus, "onUpdate:modelValue": o[0] || (o[0] = (e) => n(c).query.auditStatus = e), options: ie.value, showOptionAll: "", style: { float: "right" }, size: "default", type: "enum", onChange: n(c).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), A("div", We, [d.moneySum.collectionAmount ? (a(), m(y, { key: 0, type: "warning", size: "large", style: { "margin-left": "5px" } }, { default: i(() => [S(" 已收款【审核通过】：" + f(n(Z)(d.moneySum.collectionAmount, n(D).contract)), 1)]), _: 1 })) : x("", true), O(r(C, { "api-key": "scrapCollection", params: n(c).query, style: { "margin-left": "5px", float: "right" }, size: "default", type: "warning" }, null, 8, ["params"]), [[J, n(c).permission.print]])])]), O((a(), m(ve, { ref_key: "tableRef", ref: H, data: n(c).data, "empty-text": n(c).emptyText, "max-height": n(ue), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "show-summary": "", "summary-method": we, "cell-class-name": re, stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: i(() => [r(s, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), r(s, { key: "collectionDate", prop: "collectionDate", label: "收款日期", align: "center", width: "160" }, { default: i((e) => [e.row.isModify ? (a(), m(T, { key: 0, modelValue: e.row.collectionDate, "onUpdate:modelValue": (u) => e.row.collectionDate = u, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), g("div", Xe, f(e.row.collectionDate ? n(Oe)(e.row.collectionDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), r(s, { key: "collectionAmount2", prop: "collectionAmount2", label: "收款金额", align: "center", "min-width": "170", class: "money-column" }, { default: i(() => [r(s, { key: "collectionAmount", prop: "collectionAmount", label: "金额", align: "center", "min-width": "85" }, { default: i((e) => [e.row.isModify ? O((a(), m(k, { modelValue: e.row.collectionAmount, "onUpdate:modelValue": (u) => e.row.collectionAmount = u, modelModifiers: { number: true }, min: -9999999999, max: 9999999999, step: 100, precision: n(D).contract, placeholder: "收款金额(元)", "controls-position": "right", key: e.row.dataIndex ? e.row.dataIndex : e.row.id, onChange: (u) => de(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])), [[Ae]]) : (a(), g("div", Ze, f(n(ee)(e.row.collectionAmount) ? n(Z)(e.row.collectionAmount, n(D).contract) : "-"), 1))]), _: 1 }), r(s, { key: "collectionAmount1", prop: "collectionAmount1", label: "大写", align: "center", "min-width": "85", "show-overflow-tooltip": true }, { default: i((e) => [A("div", null, f(n(ee)(e.row.collectionAmount) ? n(Pe)(e.row.collectionAmount) : ""), 1)]), _: 1 })]), _: 1 }), r(s, { key: "collectionReason", prop: "collectionReason", label: "收款事由", align: "center", width: "120" }, { default: i((e) => [e.row.isModify ? (a(), m(V, { key: 0, modelValue: e.row.collectionReason, "onUpdate:modelValue": (u) => e.row.collectionReason = u, options: n(B).payment_reason, type: "dict", size: "default", clearable: "", placeholder: "收款事由", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (a(), g("div", et, f(e.row.collectionReason && n(B) && n(B).label && n(B).label.payment_reason ? n(B).label.payment_reason[e.row.collectionReason] : ""), 1))]), _: 1 }), r(s, { key: "collectionMode", prop: "collectionMode", label: "收款方式", align: "center", width: "110" }, { default: i((e) => [e.row.isModify ? (a(), m(V, { key: 0, modelValue: e.row.collectionMode, "onUpdate:modelValue": (u) => e.row.collectionMode = u, options: ce.value, type: "enum", size: "default", placeholder: "收款方式", style: { width: "100%" }, onChange: (u) => ke(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (a(), g("div", tt, f(e.row.collectionMode ? n(h).VL[e.row.collectionMode] : ""), 1))]), _: 1 }), r(s, { key: "collectionUnit", prop: "collectionUnit", label: "收款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: i((e) => [A("div", null, f(e.row.collectionUnit), 1)]), _: 1 }), r(s, { key: "collectionBankAccountId", prop: "collectionBankAccountId", "show-overflow-tooltip": true, label: "收款银行", align: "center", "min-width": "120" }, { default: i((e) => [e.row.isModify ? (a(), m(V, { key: 0, modelValue: e.row.collectionBankAccountId, "onUpdate:modelValue": (u) => e.row.collectionBankAccountId = u, options: N.value, type: "other", dataStructure: le, size: "default", placeholder: "收款银行", clearable: "", style: { width: "100%" }, onChange: (u) => pe(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (a(), g("div", ot, f(e.row.collectionDepositBank), 1))]), _: 1 }), r(s, { key: "collectionBankAccount", prop: "collectionBankAccount", "show-overflow-tooltip": true, label: "银行卡号", align: "center", "min-width": "120" }, { default: i((e) => [e.row.isModify ? (a(), m(E, { key: 0, modelValue: e.row.collectionBankAccount, "onUpdate:modelValue": (u) => e.row.collectionBankAccount = u, modelModifiers: { trim: true }, placeholder: "银行卡号", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), g("div", nt, f(e.row.collectionBankAccount), 1))]), _: 1 }), r(s, { key: "paymentUnit", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: i((e) => [A("div", null, f(e.row.paymentUnit), 1)]), _: 1 }), r(s, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "90", "show-overflow-tooltip": true }, { default: i((e) => [e.row.isModify ? (a(), m(E, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (u) => e.row.remark = u, modelModifiers: { trim: true }, placeholder: "备注", type: "textarea", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), g("div", lt, f(e.row.remark), 1))]), _: 1 }), r(s, { key: "writtenByName", prop: "writtenByName", label: "办理人", align: "center", width: "100px" }, { default: i((e) => [A("div", null, f(e.row.writtenByName), 1)]), _: 1 }), r(s, { key: "auditorName", prop: "auditorName", label: "审核人", align: "center", width: "100px" }, { default: i((e) => [A("div", null, f(e.row.auditorName), 1)]), _: 1 }), n(P)([...n(b).edit, ...n(b).audit]) ? (a(), m(s, { key: 0, label: "操作", width: "190px", align: "center" }, { default: i((e) => [e.row.isModify ? (a(), g(W, { key: 1 }, [r(F, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (u) => _e(e.row, e.$index) }, { reference: i(() => [r(l, { type: "info", plain: "", size: "default" }, { default: i(() => o[4] || (o[4] = [S("取消")])), _: 1, __: [4] })]), _: 2 }, 1032, ["onConfirm"]), r(l, { type: "primary", size: "default", onClick: (u) => he(e.row) }, { default: i(() => o[5] || (o[5] = [S("保存")])), _: 2, __: [5] }, 1032, ["onClick"])], 64)) : (a(), g(W, { key: 0 }, [e.row.auditStatus === n(I).AUDITING.V && n(P)(n(b).edit) ? (a(), m(l, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (u) => ye(e.row) }, null, 8, ["onClick"])) : x("", true), e.row.auditStatus === n(I).AUDITING.V && n(P)(n(b).del) ? (a(), m(F, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (u) => ge(e.row) }, { reference: i(() => [r(l, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : x("", true), e.row.auditStatus === n(I).AUDITING.V && n(P)(n(b).audit) ? (a(), m(F, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (u) => fe(e.row) }, { reference: i(() => [r(l, { type: "success", size: "default" }, { default: i(() => o[2] || (o[2] = [S("通过")])), _: 1, __: [2] })]), _: 2 }, 1032, ["onConfirm"])) : x("", true), e.row.auditStatus === n(I).PASS.V ? (a(), m(y, { key: 3, type: "success", class: "pass-tag" }, { default: i(() => o[3] || (o[3] = [S("已复核")])), _: 1, __: [3] })) : x("", true)], 64))]), _: 1 })) : x("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[be, n(c).loading]]), r(n(ze), { projectId: d.projectId, currentRow: d.currentRow }, null, 8, ["projectId", "currentRow"]), r(n(qe))]);
  };
} }, dt = Ue(at, [["__scopeId", "data-v-f90ff5f1"]]);
export {
  dt as default
};
