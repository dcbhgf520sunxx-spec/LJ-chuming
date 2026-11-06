import { ref as d } from "vue";
import { computed as F } from "vue";
import { onMounted as ne } from "vue";
import { onUnmounted as ie } from "vue";
import { resolveComponent as re } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as i } from "vue";
import { unref as l } from "vue";
import { withDirectives as C } from "vue";
import { vShow as M } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as x } from "vue";
import { createBlock as D } from "vue";
import { toDisplayString as k } from "vue";
import { normalizeStyle as V } from "vue";
import { Fragment as de } from "vue";
import { renderList as ue } from "vue";
import { withModifiers as O } from "vue";
import { createCommentVNode as E } from "vue";
import { nextTick as pe } from "vue";
import { ElMessage as fe } from "element-plus";
import { ElTag as he } from "element-plus";
import { ElCheckbox as ge } from "element-plus";
import { ElImage as _e } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { Loading as me } from "@element-plus/icons-vue";
import { ElIcon as ye } from "element-plus";
import { ElInfiniteScroll as xe } from "element-plus";
import "../../../../modules/el-infinite-scroll-4ed993c7.js";
import { c as ke } from "../../../../modules/machine-part-b1b959c2.js";
import { R as S } from "../../../../modules/raf-ac2cc4f2.js";
import { C as W } from "../../../../modules/bridge-86f96a4f.js";
import { _ as be, x as Ce, o as we, aN as qe, V as Ie } from "../../../../shared/runtime.js";
import Ne from "./module/header.vue.js";
import Le from "./module/preview.vue.js";
import Ve from "./module/project-list.vue.js";
import "../../../../modules/index-21d3d7d7.js";
import "../common/project-header-time.vue.js";
const Ee = { class: "app-container wrap" }, Se = { class: "wrap-left" }, $e = { class: "wrap-right" }, He = { class: "head-container" }, Re = { style: { display: "flex" } }, je = ["infinite-scroll-disabled"], Pe = ["onMouseleave"], Te = { style: { display: "flex", "justify-content": "space-between", width: "100%", "align-items": "center", padding: "0 5px" } }, ze = { class: "ellipsis-text text" }, Ue = { class: "error-slot" }, Be = { key: 0 }, Fe = { key: 1 }, Me = ["onClick"], De = { key: 0, class: "red-tip" }, A = 1e3, Oe = { __name: "index", setup(We) {
  const K = { add: false, edit: false, del: false, download: false }, b = d(), Q = d(), { crud: a, CRUD: w } = Ce({ title: "零件排产", sort: [], permission: { ...W }, optShow: { ...K }, crudApi: { ...ke }, queryOnPresenterCreated: false, hasPagination: false, requiredQuery: ["monthList", "material", "projectIds", "thick"] }, Q), { maxHeight: $ } = we(), h = d([]), v = d({ totalNetWeight: 0, quantity: 0 });
  w.HOOK.handleRefresh = (o, e) => {
    var s, c;
    J(), v.value.totalNetWeight = ((s = e.data) == null ? void 0 : s.totalNetWeight) || 0, v.value.quantity = ((c = e.data) == null ? void 0 : c.quantity) || 0, e.data.content = e.data.collect.map((g) => (g.checked = false, g.visibleTip = false, g.imgLoad = true, g));
  };
  const m = d(), H = d(), q = F(() => m.value ? (I(), m.value.boxScale) : 1), R = F(() => ({ "font-size": `${(16 * q.value).toFixed(0)}px`, width: `${(120 * q.value).toFixed(0)}px`, height: `${(120 * q.value).toFixed(0)}px` }));
  ne(() => {
    window.addEventListener("resize", I, { passive: false });
  }), ie(() => {
    window.removeEventListener("resize", I);
  });
  function I() {
    S.clearInterval();
    const o = 200, e = H.value;
    if (!e || !a.page.hasNextPage || e.scrollHeight > e.clientHeight + o) return;
    let c = 0;
    console.log(A), S.setInterval(() => {
      e && a.page.hasNextPage && e.scrollHeight < e.clientHeight + o && ++c <= 10 ? N() : S.clearInterval();
    }, A);
  }
  async function N() {
    a.firstLoaded && a.page.hasNextPage && await a.pageChangeHandler(++a.page.page);
  }
  w.HOOK.beforeRefresh = () => {
    h.value = [], v.value = { totalNetWeight: 0, quantity: 0 };
  }, w.HOOK.afterRefresh = () => {
    a.data.forEach((o) => {
      h.value.push(o);
    });
  };
  function X(o, e) {
    a.query.monthList = e, a.query.projectIds = qe(o).map((s) => s.projectId), pe(() => {
      var s;
      (s = m.value) == null || s.refreshConditions();
    });
  }
  async function G() {
    var e, s;
    console.log(a.query.projectIds);
    const o = Ie(a.query);
    y.value = false, h.value = [], a.page.page = 1, await ((e = b == null ? void 0 : b.value) == null ? void 0 : e.refresh(o)), await ((s = m.value) == null ? void 0 : s.refreshConditions(o));
  }
  const y = d(false), p = d([]);
  function J() {
    p.value = [];
  }
  function j(o, e) {
    const s = p.value.findIndex((c) => c.id === e.id);
    o ? s === -1 && p.value.push(e) : s > -1 && p.value.splice(s, 1);
  }
  function Y(o) {
    y.value = o, h.value.forEach((e) => {
      (e.imgLoad || a.query.thick === "其它") && (e.checked = o, j(o, e));
    });
  }
  const L = d(false);
  function Z() {
    var o;
    if (!((o = p.value) != null && o.length)) {
      fe.warning("请至少选择一条数据");
      return;
    }
    L.value = true;
  }
  return (o, e) => {
    var P, T, z, U;
    const s = he, c = ge, g = re("common-button"), ee = _e, te = ve, ae = me, oe = ye, se = ce("permission"), le = xe;
    return u(), _("div", Ee, [n("div", Se, [i(l(Ve), { ref_key: "projectListRef", ref: b, maxHeight: l($), onProjectClick: X }, null, 8, ["maxHeight"])]), n("div", $e, [C(i(s, { type: "info", size: "large" }, { default: r(() => e[3] || (e[3] = [x(" * 请先选择项目，进行零件排产 ")])), _: 1, __: [3] }, 512), [[M, !((T = (P = l(a).query) == null ? void 0 : P.projectIds) != null && T.length)]]), C(n("div", null, [n("div", He, [i(l(Ne), { ref_key: "headRef", ref: m, onLoad: N }, { optLeft: r(() => [n("div", Re, [i(c, { modelValue: y.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => y.value = t), size: "default", style: { "margin-right": "5px" }, indeterminate: p.value.length > 0 && p.value.length !== h.value && !y.value, border: "", onChange: Y }, { default: r(() => e[4] || (e[4] = [x("全选")])), _: 1, __: [4] }, 8, ["modelValue", "indeterminate"]), C((u(), D(g, { type: "success", class: "filter-item", size: "default", onClick: Z }, { default: r(() => e[5] || (e[5] = [x("预览并保存")])), _: 1, __: [5] })), [[se, l(W).save]])])]), viewLeft: r(() => [i(s, { size: "large", effect: "plain", style: { "margin-right": "5px" } }, { default: r(() => [x(" 数量(件)：" + k(v.value.quantity || 0), 1)]), _: 1 }), i(s, { size: "large", effect: "plain", style: { "margin-right": "10px" } }, { default: r(() => {
      var t;
      return [x(" 重量(kg)：" + k(((t = v.value.totalNetWeight) == null ? void 0 : t.toFixed(2)) || 0), 1)];
    }), _: 1 })]), _: 1 }, 512)]), l(a).firstLoaded ? C((u(), _("div", { key: 0, ref_key: "scrollBoxRef", ref: H, class: "board-container", "infinite-scroll-disabled": l(a).loading || !l(a).page.hasNextPage, "infinite-scroll-delay": 200, "infinite-scroll-distance": 200, "infinite-scroll-immediate-check": true, style: V({ "max-height": `${l($) - 90}px` }) }, [(u(true), _(de, null, ue(h.value, (t) => {
      var B;
      return u(), D(te, { key: t.id, modelValue: t.visibleTip, "onUpdate:modelValue": (f) => t.visibleTip = f, manual: "", "open-delay": 300, class: "item", effect: "light", content: `${(B = t.project) == null ? void 0 : B.shortName}

          编号：${t.serialNumber}

          长度：${t.length} mm

          单重：${t.netWeight} kg

          数量：${t.quantity}

          `, placement: "left-start" }, { default: r(() => [n("div", { class: "board-box", style: V([{ position: "relative", cursor: "pointer" }, { "background-color": `${t.boxColor}`, ...R.value }]), onMouseleave: (f) => t.visibleTip = false }, [n("div", Te, [i(c, { modelValue: t.checked, "onUpdate:modelValue": (f) => t.checked = f, disabled: !t.imgLoad && l(a).query.thick !== "其它", onClick: e[1] || (e[1] = O(() => {
      }, ["stop"])), onChange: (f) => j(f, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), n("span", ze, k(t.serialNumber), 1)]), i(ee, { style: { flex: "1", width: "95%" }, src: t.picturePath, onError: (f) => t.imgLoad = false }, { error: r(() => [n("div", Ue, [t.picturePath ? (u(), _("span", Be, "加载失败")) : (u(), _("span", Fe, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"]), n("span", { class: "ellipsis-text text", onClick: O((f) => t.visibleTip = !t.visibleTip, ["stop"]) }, k(t.specification) + "/" + k(t.quantity), 9, Me)], 44, Pe)]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "content"]);
    }), 128)), !h.value.length && !l(a).loading ? (u(), _("span", De, "* 暂无数据")) : E("", true), l(a).loading ? (u(), _("div", { key: 1, class: "loading-box", style: V(R.value) }, [e[6] || (e[6] = n("span", null, "加载中", -1)), i(oe, null, { default: r(() => [i(ae)]), _: 1 })], 4)) : E("", true)], 12, je)), [[le, N]]) : E("", true), i(l(Le), { visible: L.value, "onUpdate:visible": e[2] || (e[2] = (t) => L.value = t), list: p.value, onSuccess: G }, null, 8, ["visible", "list"])], 512), [[M, (U = (z = l(a).query) == null ? void 0 : z.projectIds) == null ? void 0 : U.length]])])]);
  };
} }, ot = be(Oe, [["__scopeId", "data-v-df71ce59"]]);
export {
  ot as default
};
