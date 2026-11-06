import { ref as f } from "vue";
import { inject as A } from "vue";
import { watch as ae } from "vue";
import { computed as O } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as p } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as b } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as w } from "vue";
import { unref as u } from "vue";
import { withDirectives as U } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as V } from "vue";
import { renderList as j } from "vue";
import { createCommentVNode as le } from "vue";
import { isRef as ne } from "vue";
import { ElMessage as oe } from "element-plus";
import { ElNotification as ie } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { vLoading as ue } from "element-plus";
import { e as ce, a as fe, t as pe } from "../../../../../modules/artifact-aa863eec.js";
import { t as me } from "../../../../../modules/common-b3e76e54.js";
import { _ as he, u as _e, o as ye, na as ve, V as H } from "../../../../../shared/runtime.js";
import { _ as F } from "../../../../../modules/index-3b2628f3.js";
const ge = { class: "tip" }, be = { class: "list-content" }, we = { class: "handle-content" }, Me = { class: "handle-title" }, xe = { class: "preview-content" }, Te = { class: "handle-title" }, Le = { __name: "handle-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(c, { emit: P }) {
  const I = f(), N = f(), R = P, i = c, { visible: L, handleClose: z } = _e({ emit: R, props: i, field: "visible" }), { maxHeight: D } = ye({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, N), M = A("handleMethodEnumV"), x = A("handleMethodEnum"), T = f(false), E = f(false), S = f([]), v = f({}), y = f([]), r = f([]);
  ae(() => i.visible, (t) => {
    t ? G() : Q();
  }, { immediate: true });
  const K = O(() => r.value.reduce((t, e) => e.dealMete ? t + e.dealMete : t, 0)), m = O(() => i.info.canHandleTotalMete - K.value);
  function Q() {
    y.value = [], r.value = [];
  }
  function X() {
    y.value = H(S.value), r.value = [];
  }
  async function G() {
    let t = [];
    try {
      if (v.value = {}, T.value = true, i.info.handleType === x.DECREASE_TASK.V) {
        const { content: e } = await me({ productType: i.info.productType, productId: i.info.productId });
        t = e.map((l) => (l.canHandleMete = l.taskQuantity - l.completeQuantity, l));
      } else {
        const { reportList: e, limitList: l } = await ce({ productType: i.info.productType, productId: i.info.productId });
        t = e.map((s) => (s.reportTypeText = ve.VL[s.reportType], s.canHandleMete = s.quantity, s)), l.forEach((s) => {
          v.value[s.processId] = s.quantity;
        });
      }
    } catch (e) {
      console.log("获取处理列表失败", e);
    } finally {
      console.log(v.value), S.value = H(t), y.value = H(t), T.value = false;
    }
  }
  function q(t) {
    return i.info.handleType === x.EXCEPTION_HANDLE.V && t.canHandleMete > v.value[t.processId] ? v.value[t.processId] : t.canHandleMete;
  }
  function J(t) {
    const e = q(t);
    return e < t.dealMete + m.value ? e : t.dealMete + m.value;
  }
  function W(t, e) {
    const l = q(e);
    l > m.value ? e.dealMete = m.value : e.dealMete = l, r.value.push({ ...e }), y.value.splice(t, 1);
  }
  function Y(t, e) {
    delete e.dealMete, y.value.push({ ...e }), r.value.splice(t, 1);
  }
  async function Z() {
    if (m.value > 0) {
      oe.warning("存在未处理数量！");
      return;
    }
    if (!(!r.value || !r.value.length)) try {
      if (E.value = true, i.info.handleType === x.EXCEPTION_HANDLE.V) {
        const t = r.value.map((e) => {
          const l = {};
          return l.id = e.id, l.quantity = e.dealMete, l;
        });
        await fe({ abnormalId: i.info.id, voList: t });
      }
      if (i.info.handleType === x.DECREASE_TASK.V) {
        const t = r.value.map((e) => {
          const l = {};
          return l.taskId = e.taskId, l.quantity = e.dealMete, l;
        });
        await pe({ abnormalId: i.info.id, taskChange: t });
      }
      ie({ title: "构件变更处理成功", type: "success", duration: 2500 }), z(), R("success");
    } catch (t) {
      console.log("变更处理失败", t);
    } finally {
      E.value = false;
    }
  }
  return (t, e) => {
    const l = C("common-button"), s = se, h = de, B = C("common-table"), ee = re, te = C("common-drawer"), $ = ue;
    return p(), g(te, { ref_key: "drawerRef", ref: N, title: `${c.info.handleType && u(M)[c.info.handleType].L}详情：${c.info.serialNumber}`, modelValue: u(L), "onUpdate:modelValue": e[0] || (e[0] = (a) => ne(L) ? L.value = a : null), direction: "rtl", "before-close": u(z), size: "100%" }, { titleRight: o(() => [n(l, { size: "default", type: "primary", loading: E.value, onClick: Z }, { default: o(() => e[1] || (e[1] = [b("提交")])), _: 1, __: [1] }, 8, ["loading"]), n(l, { size: "default", type: "warning", onClick: X }, { default: o(() => e[2] || (e[2] = [b("重置")])), _: 1, __: [2] })]), content: o(() => [d("div", ge, [e[3] || (e[3] = d("span", null, "* 注意：", -1)), d("span", null, " 可操作" + w(c.info.handleType && u(M)[c.info.handleType].L) + "的构件数量总和为" + w(c.info.canHandleTotalMete) + "，请谨慎操作！", 1)]), d("div", be, [d("div", we, [d("div", Me, [n(s, { size: "large", effect: "plain" }, { default: o(() => e[4] || (e[4] = [b("可处理列表")])), _: 1, __: [4] }), e[5] || (e[5] = d("span", null, null, -1))]), U((p(), g(B, { ref_key: "tableRef", ref: I, data: y.value, "max-height": u(D), style: { width: "100%" } }, { default: o(() => [n(h, { label: "序号", type: "index", align: "center", width: "60" }), n(u(F), { showProductionLine: "", showFactory: "" }), (p(true), k(V, null, j(u(M)[c.info.handleType].COLUMNS || [], (a) => (p(), g(h, { key: a.field, prop: a.field, "show-overflow-tooltip": true, label: a.label, width: a.width, align: a.align }, { default: o((_) => [d("span", null, w(_.row[a.field]), 1)]), _: 2 }, 1032, ["prop", "label", "width", "align"]))), 128)), n(h, { label: "操作", width: "80", align: "center" }, { default: o((a) => [n(l, { type: "primary", size: "default", icon: "el-icon-arrow-right", disabled: m.value <= 0, onClick: (_) => W(a.$index, a.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[$, T.value]])]), d("div", xe, [d("div", Te, [d("span", null, [n(s, { size: "large", effect: "plain", type: "warning" }, { default: o(() => e[6] || (e[6] = [b("预览列表")])), _: 1, __: [6] }), n(s, { size: "large", effect: "plain", type: "danger", style: { "margin-left": "10px" } }, { default: o(() => [b("剩余可操作数量：" + w(m.value), 1)]), _: 1 })])]), U((p(), g(B, { ref_key: "tableRef", ref: I, data: r.value, "max-height": u(D), style: { width: "100%" } }, { default: o(() => [n(h, { label: "序号", type: "index", align: "center", width: "60" }), n(u(F), { showProductionLine: "", showFactory: "" }), (p(true), k(V, null, j(u(M)[c.info.handleType].COLUMNS || [], (a) => (p(), k(V, { key: a.field }, [a.preview ? (p(), g(h, { key: 0, prop: a.field, "show-overflow-tooltip": true, label: a.label, width: a.width, align: a.align }, { default: o((_) => [d("span", null, w(_.row[a.field]), 1)]), _: 2 }, 1032, ["prop", "label", "width", "align"])) : le("", true)], 64))), 128)), n(h, { prop: "dealMete", "show-overflow-tooltip": true, label: "处理量", width: "150px", align: "center" }, { default: o((a) => [n(ee, { modelValue: a.row.dealMete, "onUpdate:modelValue": (_) => a.row.dealMete = _, min: 1, max: J(a.row), style: { width: "100%" }, size: "default", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), n(h, { label: "操作", width: "80", align: "center" }, { default: o((a) => [n(l, { type: "danger", size: "default", icon: "el-icon-delete", onClick: (_) => Y(a.$index, a.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[$, T.value]])])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ie = he(Le, [["__scopeId", "data-v-b317f1d4"]]);
export {
  Ie as default
};
