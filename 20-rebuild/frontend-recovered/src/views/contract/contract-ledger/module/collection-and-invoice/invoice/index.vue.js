import { ref as T } from "vue";
import { provide as K } from "vue";
import { watch as Y } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as j } from "vue";
import { unref as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as k } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as b } from "vue";
import { Fragment as X } from "vue";
import { nextTick as xe } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTag as we } from "element-plus";
import { ElTableColumn as ke } from "element-plus";
import { ElDatePicker as be } from "element-plus";
import { ElInputNumber as Ae } from "element-plus";
import { ElCheckbox as Ve } from "element-plus";
import { ElInput as Te } from "element-plus";
import { ElPopconfirm as Ce } from "element-plus";
import { vLoading as Ie } from "element-plus";
import { b as Ne } from "../../../../../../modules/collection-9275714a.js";
import { c as q, e as Re } from "../../../../../../modules/invoice-2cd386aa.js";
import { _ as Se, t as Ue, x as Ee, c3 as C, o as De, bD as I, bV as E, p as Oe, i as R, ia as Me, iD as B, G as z, P as Pe, fK as ee } from "../../../../../../shared/runtime.js";
import { k as je } from "../../../../../../modules/contract-9b18cc88.js";
import qe from "./form.vue.js";
const Be = { class: "app-container" }, ze = { class: "clearfix" }, $e = { style: { float: "left" } }, Fe = { style: { float: "right" } }, Qe = { key: 1 }, Ge = { key: 1 }, He = { key: 0 }, Je = { style: { display: "flex" } }, Le = { style: { "padding-right": "5px" } }, Ke = { key: 1 }, Ye = { key: 1 }, We = { key: 1 }, Xe = { key: 1 }, Ze = { key: 1 }, et = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, moneySum: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(w, { emit: te }) {
  const { decimalPrecision: g } = Ue(), A = je.invoice, oe = { add: true, edit: false, del: false, download: false }, h = w, Q = T(), S = T({}), G = T({}), ne = T([]), _ = T(0), $ = T([]), ie = te;
  K("contractInfo", S), K("totalAmount", _);
  const { crud: c, CRUD: U } = Ee({ title: "开票填报", sort: [], permission: { ...A }, optShow: { ...oe }, crudApi: { ...q }, invisibleColumns: ["haveInvoiceAmount", "collectionMode", "invoiceType", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, Q), H = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ required: true, message: "请选择开票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, o) => o.invoiceType !== I.RECEIPT.V && h.currentRow.isTax !== B.NO.V && !o.checked ? R(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, J = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ required: true, message: "请选择开票额", trigger: "change", type: "number" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, ae = T([C.AUDITING, C.PASS]);
  function le({ row: t, column: o }) {
    if (!t) return;
    let i = {};
    t.invoiceType !== I.RECEIPT.V && h.currentRow.isTax !== B.NO.V ? i = H : i = J;
    let f = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (f = ee(o.property, i[o.property], t)), f && (t.verify[o.property] = true)), f ? "" : "mask-td";
  }
  const { maxHeight: re } = De({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  Y(() => h.projectId, (t) => {
    ne.value = [], S.value = {}, t && ue(t), c.toQuery();
  }, { deep: true, immediate: true }), Y(() => h.visibleValue, (t) => {
    t && c.toQuery();
  }, { deep: true, immediate: true });
  async function ue(t) {
    let o = {};
    try {
      o = await Ne({ projectId: t });
    } catch (i) {
      console.log("获取合同信息", i);
    } finally {
      S.value = o;
    }
  }
  function ce(t) {
    if (h.currentRow.settlementAmount && (_.value = 0, c.data.map((o) => {
      o.invoiceAmount && (_.value += o.invoiceAmount);
    }), _.value > h.currentRow.settlementAmount)) {
      const o = t.invoiceAmount - (_.value - h.currentRow.settlementAmount);
      xe(() => {
        t.invoiceAmount = o || 0, D(t), _.value = 0, c.data.map((i) => {
          i.invoiceAmount && (_.value += i.invoiceAmount);
        });
      });
    }
    D(t);
  }
  function de(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : t.originRate, D(t);
  }
  function D(t) {
    t.tax = 0;
    let o = t.invoiceAmount;
    R(t.invoiceAmount) && t.taxRate ? (t.tax = t.invoiceAmount * t.taxRate / 100, o = (t.invoiceAmount / (1 + t.taxRate / 100)).toFixed(g.value.contract)) : t.invoiceType === I.RECEIPT.V && (o = t.invoiceAmount), t.noTaxAmount = o;
  }
  async function se(t) {
    try {
      await Re({ id: t.id, auditStatus: C.PASS.V }), c.notify("审核成功", U.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), ie("success");
    } catch (o) {
      console.log("审核失败", o);
    }
  }
  function me(t) {
    G.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function fe(t) {
    try {
      await q.del(t.id), c.notify("删除成功", U.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (o) {
      console.log("删除失败", o);
    }
  }
  function pe(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(G.value)));
    else {
      const o = c.data.findIndex((i) => i.dataIndex === t.dataIndex);
      c.data.splice(o, 1);
    }
  }
  async function ye(t) {
    if (t.invoiceAmount === 0) {
      Z.error("开票额必须大于0");
      return;
    }
    let o = {};
    t.invoiceType !== I.RECEIPT.V && h.currentRow.isTax !== B.NO.V ? o = H : o = J;
    let i = true;
    t.verify = {};
    for (const p in o) t.verify[p] = ee(p, o[p], t), t.verify[p] || (i = false);
    if (!i) {
      Z.error("请填写表格中标红数据");
      return;
    }
    const f = t.id ? "修改" : "新增";
    try {
      t.id ? await q.edit(t) : await q.add(t), c.notify(`${f}成功`, U.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (p) {
      console.log(f, p);
    }
  }
  function ve(t) {
    const { columns: o, data: i } = t, f = [];
    return o.forEach((p, V) => {
      var d;
      if (V === 0) {
        f[V] = "查询合计";
        return;
      }
      if (p.property === "invoiceAmount") {
        const O = i.map((x) => x.invoiceAmount);
        O.every((x) => isNaN(x)) || (f[V] = O.reduce((x, M) => {
          const N = Number(M);
          return isNaN(N) ? x : x + M;
        }, 0)), f[V] = (d = f[V]) == null ? void 0 : d.toFixed(g.value.contract);
      }
    }), f;
  }
  return U.HOOK.beforeRefresh = () => {
    c.query.projectId = h.projectId;
  }, U.HOOK.handleRefresh = (t, o) => {
    _.value = 0, $.value = [], o.data.content.map((i) => {
      i.projectId = i.project.id, i.dataIndex = i.id + "id", i.invoiceAmount && (_.value += i.invoiceAmount), i.invoiceNo && $.value.push({ invoiceNo: i.invoiceNo, dataIndex: i.dataIndex }), i.checked = !i.boolIncludeTax, i.noTaxAmount = i.invoiceType !== I.RECEIPT.V ? (i.invoiceAmount / (1 + i.taxRate / 100)).toFixed(g.value.contract) : i.invoiceAmount, i.originRate = i.taxRate;
    });
  }, (t, o) => {
    const i = P("common-button"), f = P("common-radio-button"), p = we, V = P("print-table"), d = ke, O = be, x = Ae, M = Ve, N = Te, F = Ce, ge = P("common-table"), L = W("permission"), he = W("show-thousand"), _e = Ie;
    return a(), v("div", Be, [y("div", ze, [y("div", $e, [j((a(), s(i, { type: "primary", size: "default", onClick: n(c).toAdd, style: { "margin-right": "10px" } }, { default: l(() => o[1] || (o[1] = [k(" 添加 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[L, n(A).add]]), r(f, { modelValue: n(c).query.auditStatus, "onUpdate:modelValue": o[0] || (o[0] = (e) => n(c).query.auditStatus = e), options: ae.value, showOptionAll: "", size: "default", style: { float: "right" }, type: "enum", onChange: n(c).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), y("div", Fe, [S.value.contractAmount ? (a(), s(p, { key: 0, type: "success", size: "large" }, { default: l(() => [k(m("合同金额：" + n(E)(S.value.contractAmount, n(g).contract)), 1)]), _: 1 })) : b("", true), w.currentRow.settlementAmount ? (a(), s(p, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: l(() => [k(m("结算金额：" + n(E)(w.currentRow.settlementAmount, n(g).contract)), 1)]), _: 1 })) : b("", true), w.moneySum.invoiceAmount ? (a(), s(p, { key: 2, type: "warning", size: "large", style: { "margin-left": "5px" } }, { default: l(() => [k(" 已开票【审核通过】：" + m(n(E)(w.moneySum.invoiceAmount, n(g).contract)), 1)]), _: 1 })) : b("", true), j(r(V, { "api-key": "invoiceRecord", params: n(c).query, style: { "margin-left": "5px", float: "right" }, size: "default", type: "warning" }, null, 8, ["params"]), [[L, n(c).permission.print]])])]), j((a(), s(ge, { ref_key: "tableRef", ref: Q, data: n(c).data, "empty-text": n(c).emptyText, "max-height": n(re), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": le, stripe: false, "return-source-data": "", "show-summary": "", "summary-method": ve, showEmptySymbol: false }, { default: l(() => [r(d, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), r(d, { key: "invoiceDate", prop: "invoiceDate", label: "开票日期", align: "center", width: "145" }, { default: l((e) => [e.row.isModify ? (a(), s(O, { key: 0, modelValue: e.row.invoiceDate, "onUpdate:modelValue": (u) => e.row.invoiceDate = u, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), v("div", Qe, m(e.row.invoiceDate ? n(Oe)(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), r(d, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "开票额", align: "center", "min-width": "180", class: "money-column" }, { default: l(() => [r(d, { key: "invoiceAmount", prop: "invoiceAmount", label: "金额", align: "center", "min-width": "110" }, { default: l((e) => [e.row.isModify ? j((a(), s(x, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (u) => e.row.invoiceAmount = u, modelModifiers: { number: true }, min: -9999999999, max: 9999999999, step: 100, precision: n(g).contract, placeholder: "开票额(元)", "controls-position": "right", onChange: (u) => ce(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])), [[he]]) : (a(), v("div", Ge, m(n(R)(e.row.invoiceAmount) ? n(E)(e.row.invoiceAmount, n(g).contract) : "-"), 1))]), _: 1 }), r(d, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", "min-width": "110", "show-overflow-tooltip": true }, { default: l((e) => [y("div", null, m(n(R)(e.row.invoiceAmount) ? n(Me)(e.row.invoiceAmount) : "-"), 1)]), _: 1 })]), _: 1 }), r(d, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", width: "110" }, { default: l((e) => [y("div", null, m(e.row.invoiceType ? n(I).VL[e.row.invoiceType] : "-"), 1)]), _: 1 }), r(d, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "130" }, { default: l((e) => [e.row.invoiceType !== n(I).RECEIPT.V && w.currentRow.isTax !== n(B).NO.V && e.row.isModify ? (a(), v("div", He, [y("div", Je, [y("div", Le, [r(M, { modelValue: e.row.checked, "onUpdate:modelValue": (u) => e.row.checked = u, label: "免税", size: "large", onChange: (u) => de(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), r(x, { modelValue: e.row.taxRate, "onUpdate:modelValue": (u) => e.row.taxRate = u, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "80px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (u) => D(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), o[2] || (o[2] = y("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (a(), v("div", Ke, m(e.row.checked ? "免税" : n(R)(e.row.taxRate) ? e.row.taxRate + "%" : ""), 1))]), _: 1 }), r(d, { key: "noTaxAmount", prop: "noTaxAmount", label: "不含税金额", align: "center", width: "70" }, { default: l((e) => [y("span", null, m(n(R)(e.row.noTaxAmount) ? n(E)(e.row.noTaxAmount, n(g).contract) : "-"), 1)]), _: 1 }), r(d, { key: "invoiceUnit", prop: "invoiceUnit", label: "开票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l((e) => [y("div", null, m(e.row.invoiceUnit), 1)]), _: 1 }), r(d, { key: "collectionUnit", prop: "collectionUnit", label: "收票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l((e) => [e.row.isModify ? (a(), s(N, { key: 0, modelValue: e.row.collectionUnit, "onUpdate:modelValue": (u) => e.row.collectionUnit = u, modelModifiers: { trim: true }, placeholder: "收票单位", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), v("div", Ye, m(e.row.collectionUnit), 1))]), _: 1 }), r(d, { prop: "invoiceNo", label: "发票号码", align: "center", "min-width": "130" }, { default: l((e) => [e.row.isModify ? (a(), s(N, { key: 0, modelValue: e.row.invoiceNo, "onUpdate:modelValue": (u) => e.row.invoiceNo = u, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), v("span", We, m(e.row.invoiceNo), 1))]), _: 1 }), r(d, { prop: "invoiceContent", label: "发票内容", align: "center", "min-width": "130" }, { default: l((e) => [e.row.isModify ? (a(), s(N, { key: 0, modelValue: e.row.invoiceContent, "onUpdate:modelValue": (u) => e.row.invoiceContent = u, modelModifiers: { trim: true }, type: "text", placeholder: "发票内容", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), v("span", Xe, m(e.row.invoiceContent), 1))]), _: 1 }), r(d, { prop: "remark", label: "备注", align: "center", "min-width": "100" }, { default: l((e) => [e.row.isModify ? (a(), s(N, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (u) => e.row.remark = u, modelModifiers: { trim: true }, type: "textarea", placeholder: "备注", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), v("span", Ze, m(e.row.remark), 1))]), _: 1 }), r(d, { key: "writtenByName", prop: "writtenByName", label: "办理人", align: "center", width: "80px" }, { default: l((e) => [y("div", null, m(e.row.writtenByName), 1)]), _: 1 }), r(d, { key: "auditorName", prop: "auditorName", label: "审核人", align: "center", width: "80px" }, { default: l((e) => [y("div", null, m(e.row.auditorName), 1)]), _: 1 }), n(z)([...n(A).edit, ...n(A).audit]) ? (a(), s(d, { key: 0, label: "操作", width: "190px", align: "center" }, { default: l((e) => [e.row.isModify ? (a(), v(X, { key: 1 }, [r(F, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (u) => pe(e.row, e.$index) }, { reference: l(() => [r(i, { type: "primary", size: "default" }, { default: l(() => o[5] || (o[5] = [k("取消")])), _: 1, __: [5] })]), _: 2 }, 1032, ["onConfirm"]), r(i, { type: "info", plain: "", size: "default", onClick: (u) => ye(e.row) }, { default: l(() => o[6] || (o[6] = [k("保存")])), _: 2, __: [6] }, 1032, ["onClick"])], 64)) : (a(), v(X, { key: 0 }, [e.row.auditStatus === n(C).AUDITING.V && n(z)(n(A).edit) ? (a(), s(i, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (u) => me(e.row) }, null, 8, ["onClick"])) : b("", true), e.row.auditStatus === n(C).AUDITING.V && n(z)(n(A).del) ? (a(), s(F, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (u) => fe(e.row) }, { reference: l(() => [r(i, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : b("", true), e.row.auditStatus === n(C).AUDITING.V && n(z)(n(A).audit) ? (a(), s(F, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (u) => se(e.row) }, { reference: l(() => [r(i, { type: "success", size: "default" }, { default: l(() => o[3] || (o[3] = [k("通过")])), _: 1, __: [3] })]), _: 2 }, 1032, ["onConfirm"])) : b("", true), e.row.auditStatus === n(C).PASS.V ? (a(), s(p, { key: 3, type: "success", class: "pass-tag" }, { default: l(() => o[4] || (o[4] = [k("已复核")])), _: 1, __: [4] })) : b("", true)], 64))]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[_e, n(c).loading]]), r(n(Pe)), r(n(qe), { existInvoiceNo: $.value, projectId: w.projectId, currentRow: w.currentRow }, null, 8, ["existInvoiceNo", "projectId", "currentRow"])]);
  };
} }, ut = Se(et, [["__scopeId", "data-v-86fc8781"]]);
export {
  ut as default
};
