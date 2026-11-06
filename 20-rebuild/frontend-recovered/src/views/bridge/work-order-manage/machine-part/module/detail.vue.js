import { inject as G } from "vue";
import { ref as s } from "vue";
import { computed as K } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as d } from "vue";
import { createBlock as N } from "vue";
import { withCtx as u } from "vue";
import { createVNode as O } from "vue";
import { unref as e } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as Q } from "vue";
import { createElementBlock as L } from "vue";
import { createCommentVNode as C } from "vue";
import { isRef as W } from "vue";
import { ElLoading as J } from "element-plus";
import { ElMessage as X } from "element-plus";
import { ElNotification as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { co as p, o as ee, u as te, ci as ae, cj as oe, $ as D, cl as re, bg as ie } from "../../../../../shared/runtime.js";
import { u as se, p as ne, a as le } from "../../../../../modules/use-get-separate-order-8068bd15.js";
import { c as ce } from "../../../../../modules/index-069ba252.js";
import de from "./separate-order-table.vue.js";
import ue from "./production-task-order.vue.js";
import "../../../../../modules/index-90569c81.js";
import "../../../../../modules/constant_2-1ad5d80f.js";
import "../../../../../modules/label-logo-8a01bd73.js";
import "../../../../../modules/index-f09320a8.js";
import "../../../../../modules/index-3b2e6e51.js";
const pe = { key: 0 }, me = { key: 1 }, S = "bridgeDrillProductionTaskOrder", Te = { __name: "detail", props: { visible: { type: Boolean, required: true }, detailData: { type: Object, default: () => {
} }, processType: { type: Number } }, emits: ["update:visible"], setup(U, { emit: M }) {
  const j = G("permission"), h = M, k = s(), T = s([]), m = s(false), n = s(p.PRODUCTION_TASK_ORDER.V), r = U, { maxHeight: B } = ee({ wrapperBox: [".el-drawer__body"], navbar: false }, k), l = K(() => ({ cutId: r.detailData.id, processType: r.processType })), { separateLoading: H, separateOrderInfo: V, fetchSeparateOrder: P } = se(l), { visible: f, handleClose: $ } = te({ emit: h, props: r, field: "visible", showHook: q });
  async function q() {
    await z(), await P();
  }
  async function z() {
    try {
      m.value = true;
      const t = await ne({ ...l.value });
      T.value = t;
    } catch (t) {
      console.log("获取钻孔工单详情失败", t);
    } finally {
      m.value = false;
    }
  }
  const o = s();
  async function A() {
    o.value = J.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      o.value.text = "正在加载数据：生产任务单";
      const t = ae[S], { header: a, footer: v, table: _, qrCode: b } = await oe[S]({ ...l.value }) || {};
      o.value.text = "正在加入打印队列：生产任务单", await D(500);
      const i = await re({ printMode: ie.CUSTOM_QUEUE.V, header: a, footer: v, table: _, qrCode: b, config: t });
      if (typeof i == "object") {
        const { type: w, message: c } = i;
        return o.value.close(), X({ type: w, message: c });
      }
      if (!i) throw new Error("导出失败");
      o.value.text = "正在加入打印队列：分拣单", await D(500), await ce({ taskNumberOrder: r.detailData.orderNumber, separateOrderInfo: V.value }), o.value.text = "已全部加入打印队列", await D(500);
    } catch (t) {
      throw Y({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(t);
    } finally {
      o.value.close(), await le({ ...l.value }), h("refresh");
    }
  }
  return (t, a) => {
    var c, x, E, R;
    const v = g("common-radio-button"), _ = g("common-button"), b = g("common-drawer"), i = F("permission"), w = Z;
    return d(), N(b, { ref_key: "drawerRef", ref: k, title: `${(x = (c = r.detailData) == null ? void 0 : c.workshop) == null ? void 0 : x.name}>${(R = (E = r.detailData) == null ? void 0 : E.productionLine) == null ? void 0 : R.name}钻孔详情`, modelValue: e(f), "onUpdate:modelValue": a[1] || (a[1] = (y) => W(f) ? f.value = y : null), direction: "rtl", "before-close": e($), size: "60%" }, { titleAfter: u(() => [O(v, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (y) => n.value = y), options: e(p).ENUM, type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options"])]), titleRight: u(() => [I((d(), N(_, { size: "default", icon: "el-icon-printer", type: "success", onClick: A }, { default: u(() => a[2] || (a[2] = [Q("打印【任务单、分拣单】")])), _: 1, __: [2] })), [[i, e(j).print]])]), content: u(() => [n.value === e(p).PRODUCTION_TASK_ORDER.V ? (d(), L("div", pe, [O(e(ue), { tableData: T.value, maxHeight: e(B), tableLoading: m.value }, null, 8, ["tableData", "maxHeight", "tableLoading"])])) : C("", true), n.value === e(p).SORTING_ORDER.V ? I((d(), L("div", me, [O(e(de), { separateOrderInfo: e(V) }, null, 8, ["separateOrderInfo"])])), [[w, e(H)]]) : C("", true)]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  Te as default
};
