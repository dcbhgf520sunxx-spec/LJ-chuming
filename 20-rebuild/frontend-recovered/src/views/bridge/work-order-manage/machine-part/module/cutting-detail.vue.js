import { ref as m } from "vue";
import { inject as W } from "vue";
import { computed as X } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as D } from "vue";
import { createBlock as L } from "vue";
import { withCtx as b } from "vue";
import { createVNode as y } from "vue";
import { unref as t } from "vue";
import { withDirectives as O } from "vue";
import { createTextVNode as Z } from "vue";
import { createElementBlock as U } from "vue";
import { normalizeStyle as ee } from "vue";
import { vShow as E } from "vue";
import { createElementVNode as te } from "vue";
import { isRef as ae } from "vue";
import { ElLoading as oe } from "element-plus";
import { ElMessage as re } from "element-plus";
import { ElNotification as ne } from "element-plus";
import { vLoading as ie } from "element-plus";
import { _ as se, cp as o, o as le, u as ce, a6 as ue, ci as de, cj as pe, $ as N, cl as me, bg as fe } from "../../../../../shared/runtime.js";
import { u as ve, p as _e, s as ge, a as we } from "../../../../../modules/use-get-separate-order-8068bd15.js";
import { p as De } from "../../../../../modules/print-e379c493.js";
import { c as be } from "../../../../../modules/index-069ba252.js";
import ye from "./separate-order-table.vue.js";
import Oe from "./production-task-order.vue.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-3b2e6e51.js";
const B = "bridgeNestingProductionTaskOrder", Re = { __name: "cutting-detail", props: { visible: { type: Boolean, required: true }, cuttingDetailData: { type: Object, default: () => {
} }, processType: { type: Number } }, emits: ["update:visible", "refresh"], setup(V, { emit: A }) {
  const H = "/assets", x = A, j = m(), r = V, G = W("permission"), g = m(""), c = m(false), S = m([]), i = m(o.NESTING_TASK_ORDER.V), { maxHeight: I } = le({ mainBox: ".cutting-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 100, clientHRepMainH: true }), f = X(() => ({ cutId: r.cuttingDetailData.id, processType: r.processType })), { separateLoading: K, separateOrderInfo: k, fetchSeparateOrder: M } = ve(f), { visible: R, handleClose: F } = ce({ emit: x, props: r, field: "visible", showHook: z });
  async function z() {
    r.cuttingDetailData.boolNestCut ? (i.value = o.NESTING_TASK_ORDER.V, await q()) : (i.value = o.PRODUCTION_TASK_ORDER.V, await $()), await M();
  }
  async function $() {
    try {
      c.value = true;
      const e = await _e({ ...f.value });
      S.value = e;
    } catch (e) {
      console.log("获取生产任务单详情失败", e);
    } finally {
      c.value = false;
    }
  }
  async function q() {
    try {
      c.value = true, g.value = "";
      const e = await ge({ ...f.value });
      g.value = await J(e);
    } catch (e) {
      console.log("获取套料任务单失败", e);
    } finally {
      c.value = false;
    }
  }
  function J(e) {
    return new Promise((a, v) => {
      if (e && e.data && e.data.size) {
        const l = e.data, u = new window.FileReader();
        u.readAsArrayBuffer(l), u.onload = function(n) {
          console.log(n, l, "rrrr");
          const d = n.target.result, p = l.type, w = new Blob([d], { type: p }), _ = window.URL.createObjectURL(w);
          console.log(_), a(_);
        };
      } else v();
    });
  }
  const s = m();
  async function Q() {
    s.value = oe.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      if (r.cuttingDetailData.boolNestCut) De({ printable: g.value, onPrintDialogClose: () => {
        C();
      }, onError: () => {
        throw new Error("PDF加载失败");
      } });
      else {
        s.value.text = "正在加载数据：生产任务单";
        const e = de[B], { header: a, footer: v, table: l, qrCode: u } = await pe[B]({ ...f.value }) || {};
        s.value.text = "正在加入打印队列：生产任务单", await N(500);
        const n = await me({ printMode: fe.CUSTOM_QUEUE.V, header: a, footer: v, table: l, qrCode: u, config: e });
        if (typeof n == "object") {
          const { type: d, message: p } = n;
          return s.value.close(), re({ type: d, message: p });
        }
        if (!n) throw new Error("生产任务单导出失败");
        C();
      }
      return;
    } catch (e) {
      throw ne({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(e);
    }
  }
  async function C() {
    s.value.text = "正在加入打印队列：分拣单", await N(500), await be({ taskNumberOrder: r.cuttingDetailData.orderNumber, separateOrderInfo: k.value }), s.value.text = "已全部加入打印队列", await N(500), s.value.close(), await we({ ...f.value }), x("refresh");
  }
  return (e, a) => {
    var p, w, _, P;
    const v = T("common-radio-button"), l = T("common-button"), u = T("common-drawer"), n = Y("permission"), d = ie;
    return D(), L(u, { ref_key: "drawerRef", ref: j, customClass: "cutting-detail", title: `${(w = (p = r.cuttingDetailData) == null ? void 0 : p.workshop) == null ? void 0 : w.name}>${(P = (_ = r.cuttingDetailData) == null ? void 0 : _.productionLine) == null ? void 0 : P.name}切割详情`, modelValue: t(R), "onUpdate:modelValue": a[1] || (a[1] = (h) => ae(R) ? R.value = h : null), direction: "rtl", "before-close": t(F), size: "63%" }, { titleAfter: b(() => [y(v, { modelValue: i.value, "onUpdate:modelValue": a[0] || (a[0] = (h) => i.value = h), options: t(o).ENUM, unshowVal: V.cuttingDetailData.boolNestCut ? [t(o).PRODUCTION_TASK_ORDER.V] : [t(o).NESTING_TASK_ORDER.V], type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal"])]), titleRight: b(() => [O((D(), L(l, { size: "default", icon: "el-icon-printer", type: "success", onClick: Q }, { default: b(() => a[2] || (a[2] = [Z("打印【任务单、分拣单】")])), _: 1, __: [2] })), [[n, t(G).print]])]), content: b(() => [O((D(), U("div", { style: ee(`height:${t(I)}px`) }, [y(t(ue), { url: g.value, type: "canvas", pdfjsDistPath: H }, null, 8, ["url"])], 4)), [[d, c.value], [E, i.value === t(o).NESTING_TASK_ORDER.V]]), O(te("div", null, [y(t(Oe), { tableData: S.value, maxHeight: t(I), tableLoading: c.value }, null, 8, ["tableData", "maxHeight", "tableLoading"])], 512), [[E, i.value === t(o).PRODUCTION_TASK_ORDER.V]]), O((D(), U("div", null, [y(t(ye), { separateOrderInfo: t(k) }, null, 8, ["separateOrderInfo"])])), [[d, t(K)], [E, i.value === t(o).SORTING_ORDER.V]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ue = se(Re, [["__scopeId", "data-v-a36184e9"]]);
export {
  Ue as default
};
