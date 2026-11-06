import { ref as c } from "vue";
import I from "moment";
import { watch as A } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as C } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as E } from "vue";
import { Fragment as L } from "vue";
import { normalizeStyle as y } from "vue";
import { createCommentVNode as R } from "vue";
import { toDisplayString as q } from "vue";
import { ElTree as G } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as U, G as J, z as Q, a as W } from "../../../../../shared/runtime.js";
import { h as X, i as Z } from "../../../../../modules/box-3fab54f9.js";
import { B as ee } from "../../../../../modules/bridge-86f96a4f.js";
import te from "../../common/project-header-time.vue.js";
const ae = { class: "head-container" }, oe = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%", position: "relative" }, class: "tree-custom-content" }, se = { style: { width: "100%", overflow: "hidden", "text-overflow": "ellipsis" } }, re = { __name: "project-to-area-tree", props: { heightStyle: { type: String, default: "" } }, emits: ["area-click"], setup(D, { emit: K }) {
  const z = K, u = c(), _ = c(), x = I().startOf("month").valueOf(), w = c([]), h = c(), M = c(), m = c([]), b = c([]), v = c(false), p = c([]);
  O();
  async function O() {
    if (J(ee.get)) try {
      const { content: e } = await X(), t = [];
      w.value = e.map((l) => {
        const i = I(l, "YYYY/MM");
        return t.push(i.valueOf()), { year: i.year(), month: i.month() + 1, timeStamp: i.valueOf() };
      }), t != null && t.length && (h.value = t.includes(x) ? x : t[0], k());
    } catch (e) {
      console.log("获取排程信息时间错误", e);
    }
  }
  async function k() {
    try {
      v.value = true, p.value = [];
      const { content: e } = await Z({ dateTime: h.value });
      b.value = await V(e);
    } catch (e) {
      console.log("获取排程信息，项目树错误", e);
    } finally {
      v.value = false;
    }
  }
  function V(e) {
    var l, i;
    const t = [];
    for (let o = 0; o < e.length; o++) {
      const a = e[o].monomerSchedulingDetailDO, d = [];
      for (let s = 0; s < a.length; s++) {
        const r = a[s].areaSchedulingDetailDO, N = [];
        for (let n = 0; n < r.length; n++) {
          const T = "area_" + r[n].id;
          N.push({ id: r[n].id, isLast: n === r.length - 1, rowKey: T, label: r[n].name, name: r[n].name, parentIds: [a[s].id, e[o].id], monomerId: a[s].id, factoryId: (l = r[n].factory) == null ? void 0 : l.id, workshopId: (i = r[n].workshop) == null ? void 0 : i.id, endDate: r[n].endDate, isLeaf: true, disabled: false, fontSize: 14, type: "", icon: "config-2" }), p.value.push(T);
        }
        const S = "monomer_" + a[s].id;
        d.push({ id: a[s].id, isLast: s === a.length - 1, rowKey: S, parentIds: [e[o].id], label: a[s].name, children: N, isLeaf: false, disabled: true, fontSize: 15, type: "单体", icon: "document" }), p.value.push(S);
      }
      t.push({ id: e[o].id, isLast: o === e.length - 1, rowKey: "project_" + e[o].id, parentIds: [], label: Q({ serialNumber: e[o].serialNumber, name: e[o].name, shortName: e[o].shortName }, { showProjectFullName: false, showSerialNumber: true }, false), children: d, isLeaf: false, fontSize: 16, disabled: true, type: "项目", icon: "project" });
    }
    return t;
  }
  function B(e, t) {
    e.isLeaf && (t.checked ? u.value.setChecked(t, false) : (e.monomerId === _.value || (_.value = e.monomerId, u.value.setCheckedNodes([])), u.value.setChecked(t, true)), z("area-click", u.value.getCheckedNodes(true)));
  }
  A(M, (e) => {
    m.value = [], u.value.filter(e);
  });
  function F(e, t, l) {
    if (!e) return true;
    if (t.label.includes(e) || Y(t.parentIds)) return m.value.push(t.id), true;
  }
  function Y(e) {
    let t = false;
    for (let l = 0; l < e.length; l++) m.value.includes(e[l]) && (t = true);
    return t;
  }
  return (e, t) => {
    const l = W, i = G, o = H;
    return g(), j(L, null, [f("div", ae, [C(te, { modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => h.value = a), data: w.value, onChange: k, "empty-text": "暂无分段排产信息" }, null, 8, ["modelValue", "data"])]), f("div", { style: y(D.heightStyle) }, [P((g(), $(i, { ref_key: "treeMenuRef", ref: u, data: b.value, props: { children: "children", label: "label" }, "filter-node-method": F, style: { height: "100%" }, indent: 20, "expand-on-click-node": "", "node-key": "rowKey", "auto-expand-parent": false, "default-expanded-keys": p.value, onNodeClick: B }, { default: E(({ node: a, data: d }) => {
      var s, r;
      return [f("div", oe, [d.rowKey.indexOf("project") === -1 ? (g(), j(L, { key: 0 }, [t[1] || (t[1] = f("div", { style: { position: "absolute", width: "10px", "border-bottom": "1px dashed #dcdfe6", height: "1px", top: "50%", left: "-10px" } }, null, -1)), f("div", { style: y([{ position: "absolute", width: "1px", "border-right": "1px dashed #dcdfe6", left: "-10px" }, { height: d.isLast ? "calc(50% - 2px)" : (s = d.children) != null && s.length && a.expanded ? `${1 + ((r = d.children) == null ? void 0 : r.length)}00%` : "100%" }]) }, null, 4)], 64)) : R("", true), f("div", se, [C(l, { style: { "margin-right": "5px" }, "icon-class": d.icon }, null, 8, ["icon-class"]), f("span", { style: y(`font-size:${d.fontSize}px;${a.isLeaf ? "" : "font-weight: bold;"}`) }, q(a.label), 5)])])];
    }), _: 1 }, 8, ["data", "default-expanded-keys"])), [[o, v.value]])], 4)], 64);
  };
} }, fe = U(re, [["__scopeId", "data-v-a3a03692"]]);
export {
  fe as default
};
