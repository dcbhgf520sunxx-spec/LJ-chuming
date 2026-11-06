import { ref as D } from "vue";
import { inject as re } from "vue";
import { computed as ie } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as ne } from "vue";
import { openBlock as m } from "vue";
import { createBlock as w } from "vue";
import { withCtx as d } from "vue";
import { createVNode as v } from "vue";
import { unref as e } from "vue";
import { withDirectives as f } from "vue";
import { createCommentVNode as se } from "vue";
import { createTextVNode as h } from "vue";
import { vShow as g } from "vue";
import { createElementBlock as j } from "vue";
import { normalizeStyle as le } from "vue";
import { createElementVNode as ue } from "vue";
import { isRef as ce } from "vue";
import { ElLoading as de } from "element-plus";
import { ElNotification as x } from "element-plus";
import { ElMessage as F } from "element-plus";
import { ElPopconfirm as pe } from "element-plus";
import { vLoading as me } from "element-plus";
import { _ as fe, cp as a, o as _e, u as De, a6 as ve, cj as ge, $ as k, cl as Re, bg as Oe, m as currentUserState, G as canAdmin } from "../../../../../shared/runtime.js";
import { p as ye, s as we, a as G, d as be } from "../../../../../modules/machine-part-85f162b2.js";
import { p as Te } from "../../../../../modules/print-e379c493.js";
import { c as Ne } from "../../../../../modules/index-069ba252.js";
import { u as Ee } from "../../../../../modules/use-default-table-template-4b5e02c6.js";
import { u as Se } from "../../../../../modules/use-get-separate-order-0ba48739.js";
import Ve from "../../components/separate-order-table.vue.js";
import Ie from "../../components/production-task-order.vue.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-3b2e6e51.js";
const M = "mesNestingProductionTaskOrder", he = { __name: "cutting-detail", props: { visible: { type: Boolean, required: true }, cuttingDetailData: { type: Object, default: () => {
} }, processType: { type: Number }, serialNumber: { type: String } }, emits: ["update:visible", "refresh"], setup(b, { emit: $ }) {
  const { user: currentUser } = currentUserState(["user"]);
  const q = "/assets", T = $, W = D(), i = b, N = re("permission"), E = D(""), _ = D(false), L = D([]), r = D(a.NESTING_TASK_ORDER.V), { maxHeight: U } = _e({ mainBox: ".cutting-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 100, clientHRepMainH: true }), l = ie(() => ({ cutId: i.cuttingDetailData.id, processType: i.processType, serialNumber: i.serialNumber })), { separateLoading: J, separateOrderInfo: S, fetchSeparateOrder: Q } = Se(l), { visible: C, handleClose: X } = De({ emit: T, props: i, field: "visible", showHook: Y });
  async function Y() {
    i.cuttingDetailData.boolNestCut && !i.cuttingDetailData.boolOffLine ? (r.value = a.NESTING_TASK_ORDER.V, await ee()) : (r.value = a.PRODUCTION_TASK_ORDER.V, await Z()), await Q();
  }
  async function Z() {
    try {
      _.value = true;
      const t = await ye({ ...l.value });
      t == null || t.map((o) => (o.imgLoad = true, o)), L.value = t;
    } catch (t) {
      console.log("获取生产任务单详情失败", t);
    } finally {
      _.value = false;
    }
  }
  async function ee() {
    try {
      _.value = true, E.value = "";
      const t = await we({ ...l.value });
      E.value = await te(t);
    } catch (t) {
      console.log("获取套料任务单失败", t);
    } finally {
      _.value = false;
    }
  }
  function te(t) {
    return new Promise((o, R) => {
      if (t && t.data && t.data.size) {
        const p = t.data, s = new window.FileReader();
        s.readAsArrayBuffer(p), s.onload = function(u) {
          console.log(u, p, "rrrr");
          const O = u.target.result, c = p.type, V = new Blob([O], { type: c }), y = window.URL.createObjectURL(V);
          console.log(y), o(y);
        };
      } else R();
    });
  }
  async function K() {
    try {
      await G({ ...l.value }), T("refresh");
    } catch (t) {
      console.log("添加打印记录失败", t);
    }
  }
  const n = D();
  async function P() {
    n.value = de.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      if (r.value === a.NESTING_TASK_ORDER.V) Te({ printable: E.value, onPrintDialogClose: () => {
        x({ title: "打印PDF成功", type: "success", duration: 2500 });
      }, onError: () => {
        throw new Error("PDF加载失败");
      } });
      else if (r.value === a.PRODUCTION_TASK_ORDER.V) {
        n.value.text = "正在加载数据：生产任务单";
        const t = await Ee(M), { header: o, footer: R, table: p, qrCode: s } = await ge[M]({ ...l.value }) || {};
        n.value.text = "正在加入打印队列：生产任务单", await k(500);
        const u = await Re({ printMode: Oe.CUSTOM_QUEUE.V, header: o, footer: R, table: p, qrCode: s, config: t });
        if (typeof u == "object") {
          const { type: O, message: c } = u;
          return n.value.close(), F({ type: O, message: c });
        }
        if (!u) throw new Error("生产任务单导出失败");
        x({ title: "打印生产任务单成功", type: "success", duration: 2500 });
      } else S.value.length && ae();
      n.value.text = "已全部加入打印队列", await k(500), n.value.close(), await G({ ...l.value }), T("refresh");
      return;
    } catch (t) {
      throw x({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(t);
    }
  }
  async function ae() {
    n.value.text = "正在加入打印队列：分拣单", await k(500), await Ne({ taskNumberOrder: i.cuttingDetailData.orderNumber, separateOrderInfo: S.value }), n.value.text = "已全部加入打印队列", await k(500), x({ title: "打印分拣单成功", type: "success", duration: 2500 }), n.value.close(), await G({ ...l.value }), T("refresh");
  }
  function canRevokeOrder() {
    return canAdmin(["admin"]) || (currentUser.value?.id != null && i.cuttingDetailData.userId != null && String(currentUser.value.id) === String(i.cuttingDetailData.userId));
  }
  async function oe() {
    if (!canRevokeOrder()) return;
    try {
      await be(i.cuttingDetailData.taskOrderId), F({ type: "success", message: "操作成功" });
    } catch (t) {
      console.log(t);
    }
  }
  return (t, o) => {
    var y, B, z, H;
    const R = I("common-radio-button"), p = I("print-table"), s = I("common-button"), u = pe, O = I("common-drawer"), c = ne("permission"), V = me;
    return m(), w(O, { ref_key: "drawerRef", ref: W, customClass: "cutting-detail", title: `${(B = (y = i.cuttingDetailData) == null ? void 0 : y.workshop) == null ? void 0 : B.name}>${(H = (z = i.cuttingDetailData) == null ? void 0 : z.productionLine) == null ? void 0 : H.name}切割详情`, modelValue: e(C), "onUpdate:modelValue": o[1] || (o[1] = (A) => ce(C) ? C.value = A : null), direction: "rtl", "before-close": e(X), size: "63%" }, { titleAfter: d(() => [v(R, { modelValue: r.value, "onUpdate:modelValue": o[0] || (o[0] = (A) => r.value = A), options: e(a).ENUM, unshowVal: b.cuttingDetailData.boolNestCut ? b.cuttingDetailData.boolNestCut && b.cuttingDetailData.boolOffLine ? [e(a).NESTING_TASK_ORDER.V, e(a).SORTING_ORDER.V] : [e(a).PRODUCTION_TASK_ORDER.V, e(a).SORTING_ORDER.V] : [e(a).NESTING_TASK_ORDER.V, e(a).SORTING_ORDER.V], type: "enum", disabledVal: e(S).length ? [] : [e(a).SORTING_ORDER.V], size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal", "disabledVal"])]), titleRight: d(() => [r.value === e(a).PRODUCTION_TASK_ORDER.V ? f((m(), w(p, { key: 0, "api-key": "mesNestingProductionTaskOrder", params: l.value, size: "default", type: "warning", class: "filter-item", onDownloadSuccess: K, onPrintSuccess: K }, null, 8, ["params"])), [[c, e(N).print]]) : se("", true), f((m(), w(s, { size: "default", icon: "el-icon-printer", type: "success", onClick: P }, { default: d(() => o[2] || (o[2] = [h(" 打印【生产任务单】 ")])), _: 1, __: [2] })), [[g, r.value === e(a).PRODUCTION_TASK_ORDER.V], [c, e(N).print]]), f((m(), w(s, { size: "default", icon: "el-icon-printer", type: "success", onClick: P }, { default: d(() => o[3] || (o[3] = [h(" 打印【套料任务单】 ")])), _: 1, __: [3] })), [[g, r.value === e(a).NESTING_TASK_ORDER.V], [c, e(N).print]]), f((m(), w(s, { size: "default", icon: "el-icon-printer", type: "success", onClick: P }, { default: d(() => o[4] || (o[4] = [h(" 打印【分拣单】 ")])), _: 1, __: [4] })), [[g, r.value === e(a).SORTING_ORDER.V], [c, e(N).print]])]), content: d(() => [canRevokeOrder() ? v(u, { class: "filter-item", title: "是否确认全部撤回？", onConfirm: oe }, { reference: d(() => [v(s, { style: { "margin-bottom": "10px" }, class: "filter-item", type: "danger", size: "small" }, { default: d(() => o[5] || (o[5] = [h("全部工单撤回")])), _: 1, __: [5] })]), _: 1 }) : se("", true), f((m(), j("div", { style: le(`height:${e(U)}px`) }, [v(e(ve), { url: E.value, type: "canvas", pdfjsDistPath: q }, null, 8, ["url"])], 4)), [[V, _.value], [g, r.value === e(a).NESTING_TASK_ORDER.V]]), f(ue("div", null, [v(Ie, { tableData: L.value, maxHeight: e(U), tableLoading: _.value }, null, 8, ["tableData", "maxHeight", "tableLoading"])], 512), [[g, r.value === e(a).PRODUCTION_TASK_ORDER.V]]), f((m(), j("div", null, [v(e(Ve), { separateOrderInfo: e(S) }, null, 8, ["separateOrderInfo"])])), [[V, e(J)], [g, r.value === e(a).SORTING_ORDER.V]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Me = fe(he, [["__scopeId", "data-v-1b951c6d"]]);
export {
  Me as default
};
