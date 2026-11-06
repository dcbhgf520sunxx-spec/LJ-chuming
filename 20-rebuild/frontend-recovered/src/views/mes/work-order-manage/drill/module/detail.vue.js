import { inject as Q } from "vue";
import { ref as l } from "vue";
import { computed as W } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as u } from "vue";
import { createBlock as T } from "vue";
import { withCtx as c } from "vue";
import { createVNode as V } from "vue";
import { unref as e } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as L } from "vue";
import { vShow as P } from "vue";
import { createElementBlock as A } from "vue";
import { createCommentVNode as G } from "vue";
import { isRef as X } from "vue";
import { ElLoading as Y } from "element-plus";
import { ElMessage as Z } from "element-plus";
import { ElNotification as E } from "element-plus";
import { vLoading as ee } from "element-plus";
import { co as a, o as te, u as ae, cj as oe, $ as f, cl as re, bg as ie } from "../../../../../shared/runtime.js";
import { p as se, a as ne } from "../../../../../modules/machine-part-85f162b2.js";
import { c as le } from "../../../../../modules/index-069ba252.js";
import { u as ue } from "../../../../../modules/use-default-table-template-4b5e02c6.js";
import { u as ce } from "../../../../../modules/use-get-separate-order-0ba48739.js";
import de from "../../components/separate-order-table.vue.js";
import pe from "../../components/production-task-order.vue.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-3b2e6e51.js";
const me = { key: 0 }, fe = { key: 1 }, K = "mesDrillProductionTaskOrder", he = { __name: "detail", props: { visible: { type: Boolean, required: true }, detailData: { type: Object, default: () => {
} }, processType: { type: Number }, serialNumber: { type: String } }, emits: ["update:visible", "refresh"], setup(M, { emit: j }) {
  const N = Q("permission"), h = j, k = l(), I = l([]), v = l(false), o = l(a.PRODUCTION_TASK_ORDER.V), i = M, { maxHeight: B } = te({ wrapperBox: [".el-drawer__body"], navbar: false }, k), d = W(() => ({ cutId: i.detailData.id, processType: i.processType, serialNumber: i.serialNumber })), { separateLoading: H, separateOrderInfo: _, fetchSeparateOrder: z } = ce(d), { visible: O, handleClose: q } = ae({ emit: h, props: i, field: "visible", showHook: $ });
  async function $() {
    o.value = a.PRODUCTION_TASK_ORDER.V, await F(), await z();
  }
  async function F() {
    try {
      v.value = true;
      const r = await se({ ...d.value });
      I.value = r;
    } catch (r) {
      console.log("获取钻孔工单详情失败", r);
    } finally {
      v.value = false;
    }
  }
  const s = l();
  async function S() {
    s.value = Y.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      if (o.value === a.PRODUCTION_TASK_ORDER.V) {
        s.value.text = "正在加入打印队列：钻孔生产任务单";
        const r = await ue(K), { header: t, footer: b, table: p, qrCode: R } = await oe[K]({ ...d.value }) || {};
        await f(500), s.value.text = "已全部加入打印队列", await f(500);
        const n = await re({ printMode: ie.CUSTOM_QUEUE.V, header: t, footer: b, table: p, qrCode: R, config: r });
        if (typeof n == "object") {
          const { type: w, message: m } = n;
          return s.value.close(), Z({ type: w, message: m });
        }
        if (!n) throw new Error("导出失败");
        E({ title: "打印钻孔生产任务单成功", type: "success", duration: 2500 });
      } else s.value.text = "正在加入打印队列：分拣单", await f(500), await le({ taskNumberOrder: i.detailData.orderNumber, separateOrderInfo: _.value }), s.value.text = "已全部加入打印队列", await f(500), E({ title: "打印分拣单成功", type: "success", duration: 2500 });
      s.value.close(), await ne({ ...d.value }), h("refresh");
      return;
    } catch (r) {
      throw E({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(r);
    }
  }
  return (r, t) => {
    var m, x, C, U;
    const b = y("common-radio-button"), p = y("common-button"), R = y("common-drawer"), n = J("permission"), w = ee;
    return u(), T(R, { ref_key: "drawerRef", ref: k, title: `${(x = (m = i.detailData) == null ? void 0 : m.workshop) == null ? void 0 : x.name}>${(U = (C = i.detailData) == null ? void 0 : C.productionLine) == null ? void 0 : U.name}钻孔详情`, modelValue: e(O), "onUpdate:modelValue": t[1] || (t[1] = (D) => X(O) ? O.value = D : null), direction: "rtl", "before-close": e(q), size: "63%" }, { titleAfter: c(() => [V(b, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (D) => o.value = D), options: e(a).ENUM, unshowVal: [e(a).SORTING_ORDER.V], type: "enum", disabledVal: e(_).length ? [] : [e(a).SORTING_ORDER.V], size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal", "disabledVal"])]), titleRight: c(() => [g((u(), T(p, { size: "default", icon: "el-icon-printer", type: "success", onClick: S }, { default: c(() => t[2] || (t[2] = [L("打印【钻孔任务单】")])), _: 1, __: [2] })), [[P, o.value === e(a).PRODUCTION_TASK_ORDER.V], [n, e(N).print]]), g((u(), T(p, { size: "default", icon: "el-icon-printer", type: "success", onClick: S }, { default: c(() => t[3] || (t[3] = [L("打印【分拣单】")])), _: 1, __: [3] })), [[P, o.value === e(a).SORTING_ORDER.V], [n, e(N).print]])]), content: c(() => [o.value === e(a).PRODUCTION_TASK_ORDER.V ? (u(), A("div", me, [V(pe, { tableData: I.value, maxHeight: e(B), tableLoading: v.value }, null, 8, ["tableData", "maxHeight", "tableLoading"])])) : G("", true), o.value === e(a).SORTING_ORDER.V ? g((u(), A("div", fe, [V(e(de), { separateOrderInfo: e(_) }, null, 8, ["separateOrderInfo"])])), [[w, e(H)]]) : G("", true)]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  he as default
};
