import { ref as f } from "vue";
import { inject as Q } from "vue";
import { computed as q } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { unref as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as B } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as c } from "vue";
import { createElementBlock as u } from "vue";
import { isRef as J } from "vue";
import { ElMessage as W } from "element-plus";
import { ElPopconfirm as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { u as Z, o as ee, xS as ae, i as R, jl as te, G as T, xT as N, aR as oe, jG as le, jH as ne, bD as ie, z as se, xP as re, ba as ce, xQ as ue, xU as de, xV as me } from "../../../../../../../../shared/runtime.js";
const pe = { class: "mtb-10", style: { "margin-left": "30px" } }, fe = { key: 0 }, _e = { key: 1 }, ye = { key: 0 }, he = { key: 1 }, we = { key: 0 }, xe = { key: 1 }, be = { key: 0 }, ge = { key: 1 }, Ce = { __name: "list", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "refresh"], setup(j, { emit: A }) {
  const w = f([]), L = j, V = Q("permission"), H = A, { visible: x, handleClose: P } = Z({ emit: H, props: L, field: "visible", showHook: S, closeHook: $ }), d = f({ list: [] }), D = f([]), _ = f(false), r = f(false), { maxHeight: F } = ee({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => q(() => !_.value));
  function S() {
    z(), b();
  }
  function $() {
    H("refresh");
  }
  async function b() {
    _.value = true;
    try {
      const t = await ae();
      R(t == null ? void 0 : t.detailDTOList) && (t.list = await te(t == null ? void 0 : t.detailDTOList, { toSmallest: false, toNum: true })), d.value = t;
    } finally {
      _.value = false;
    }
  }
  function z() {
    d.value = { list: [] };
  }
  function E(t) {
    return ce(t, { props: ["amount"], toThousandFields: ["amount"] });
  }
  async function I() {
    r.value = true;
    try {
      await ue(d.value).then((t) => {
        t && (P(), W.success("提交审核成功"));
      });
    } finally {
      r.value = false;
    }
  }
  async function M() {
    try {
      r.value = true, await de(), await b();
    } catch (t) {
      console.log("退回", t);
    } finally {
      r.value = false;
    }
  }
  async function U(t) {
    try {
      r.value = true, await me([t.id]), await b();
    } catch (s) {
      console.log("删除", s);
    } finally {
      r.value = false;
    }
  }
  return (t, s) => {
    const g = X, O = k("table-cell-tag"), n = Y, G = k("common-table"), K = k("common-drawer");
    return l(), y(K, { ref: "drawerRef", modelValue: i(x), "onUpdate:modelValue": s[1] || (s[1] = (m) => J(x) ? x.value = m : null), "before-close": i(P), "show-close": true, "custom-class": "raw-mat-application-review-form", size: "100%", title: "盘盈清单" }, { titleRight: o(() => {
      var m, p;
      return [i(R)((m = d.value) == null ? void 0 : m.list) && i(T)(i(V).add) ? (l(), y(g, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认提交？", onConfirm: I }, { reference: o(() => [a(N, { loading: r.value, icon: "el-icon-s-promotion", size: "default", type: "primary" }, { default: o(() => s[2] || (s[2] = [h(" 提 交 ")])), _: 1, __: [2] }, 8, ["loading"])]), _: 1 })) : B("", true), i(R)((p = d.value) == null ? void 0 : p.list) ? (l(), y(g, { key: 1, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认清空？", onConfirm: M }, { reference: o(() => [a(N, { loading: r.value, icon: "el-icon-document-delete", size: "default", type: "danger" }, { default: o(() => s[3] || (s[3] = [h(" 清 空 ")])), _: 1, __: [3] }, 8, ["loading"])]), _: 1 })) : B("", true)];
    }), content: o(() => {
      var m;
      return [a(G, { data: (m = d.value) == null ? void 0 : m.list, "data-format": D.value, loading: _.value, "max-height": i(F), "summary-method": E, "expand-row-keys": w.value, "row-key": "id", "show-summary": "" }, { default: o(() => {
        var p;
        return [a(oe, { "expand-row-keys": w.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (e) => w.value = e), data: (p = d.value) == null ? void 0 : p.list, "row-key": "id", fixed: "left" }, { default: o(({ row: e }) => [C("div", pe, [C("span", null, "备注：" + c(e.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), a(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: o(({ row: e, $index: v }) => [a(O, { show: !!e.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), C("span", null, c(v + 1), 1)]), _: 1 }), a(le, { showIndex: false, "show-is-whole": "" }), a(ne), a(n, { align: "left", label: "发票类型", "min-width": "120px", prop: "invoiceType" }, { default: o(({ row: e }) => [e.boolPartyA ? (l(), u("span", _e, "-")) : (l(), u("span", fe, c(i(ie).VL[e.invoiceType]), 1))]), _: 1 }), a(n, { align: "left", label: "税率", "min-width": "100px", prop: "taxRate" }, { default: o(({ row: e }) => [e.boolPartyA ? (l(), u("span", he, "-")) : (l(), u("span", ye, c(e.taxRate) + "%", 1))]), _: 1 }), a(n, { align: "left", label: "含税单价", "min-width": "100px", prop: "unitPrice" }, { default: o(({ row: e }) => [e.boolPartyA ? (l(), u("span", xe, "-")) : (l(), u("span", we, c(e.unitPrice), 1))]), _: 1 }), a(n, { align: "left", label: "含税金额", "min-width": "100px", prop: "amount" }, { default: o(({ row: e }) => [e.boolPartyA ? (l(), u("span", ge, "-")) : (l(), u("span", be, c(e.amount), 1))]), _: 1 }), a(n, { align: "left", label: "品牌", "min-width": "120px", prop: "brand" }), a(n, { align: "left", label: "炉批号/卷号", "min-width": "120px", prop: "heatNoAndBatchNo" }), a(n, { align: "left", label: "项目", "min-width": "120px", prop: "project" }, { default: o(({ row: { sourceRow: e } }) => [h(c(i(se)(e.project) || "-"), 1)]), _: 1 }), a(n, { align: "left", label: "仓库", "min-width": "120px", prop: "workshop" }, { default: o(({ row: { sourceRow: e } }) => [a(re, { id: e.workshop ? e.workshop.id : e.workshopId }, null, 8, ["id"]), h(" " + c(e.warehouse ? e.warehouse.name : e.warehouseName), 1)]), _: 1 }), a(n, { align: "left", label: "供应商", "min-width": "120px", prop: "supplier.name" }), i(T)(i(V).add) ? (l(), y(n, { key: 0, align: "left", fixed: "right", label: "操作", width: "70px" }, { default: o(({ row: e, $index: v }) => [a(g, { title: `确认删除当前${e.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (ve) => U(e, v) }, { reference: o(() => [a(N, { loading: r.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["loading"])]), _: 2 }, 1032, ["title", "onConfirm"])]), _: 1 })) : B("", true)];
      }), _: 1 }, 8, ["data", "data-format", "loading", "max-height", "expand-row-keys"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ce as default
};
