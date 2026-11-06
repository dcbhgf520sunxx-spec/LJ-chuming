import { ref as a } from "vue";
import { onMounted as G } from "vue";
import { nextTick as T } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as p } from "vue";
import { unref as r } from "vue";
import { createBlock as v } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as Z } from "vue";
import { withModifiers as L } from "vue";
import { createCommentVNode as z } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as J } from "vue";
import { normalizeStyle as f } from "vue";
import { toDisplayString as $ } from "vue";
import { CirclePlus as Q } from "@element-plus/icons-vue";
import { Remove as X } from "@element-plus/icons-vue";
import { ElMessageBox as Y } from "element-plus";
import { ElMessage as ee } from "element-plus";
import { ElIcon as oe } from "element-plus";
import { ElTree as te } from "element-plus";
import { vLoading as se } from "element-plus";
import { _ as le, G as k, b as ae, a as ne } from "../../../../../shared/runtime.js";
import { a as ie, b as re, e as ce } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import de from "./create-project-form.vue.js";
import ue from "./create-order-form.vue.js";
const pe = { class: "head-container" }, fe = { style: { overflow: "hidden", "text-overflow": "ellipsis" } }, me = { style: { display: "flex", "align-items": "center" } }, he = { __name: "project-list", props: { maxHeight: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["order-click"], setup(d, { expose: D, emit: K }) {
  const O = K, P = d, B = a(), g = a([]), w = a(false), U = a([]), b = a(), R = a(false), x = a(false), C = a(false), S = a({}), V = a([]);
  G(() => {
    T(() => {
      u(), N();
    });
  });
  async function u() {
    if (g.value = [], !!k(P.permission.get)) try {
      w.value = true;
      const e = await ie({ workshopId: b.value });
      g.value = F(e);
    } catch (e) {
      console.log("获取排程信息，项目树错误", e);
    } finally {
      w.value = false;
    }
  }
  function F(e) {
    var m;
    const o = [];
    for (let t = 0; t < e.length; t++) {
      const h = [];
      (m = e[t].children) == null || m.forEach((n, j) => {
        var y;
        h.push({ id: n.id, isLast: j === ((y = e[t].children) == null ? void 0 : y.length) - 1, rowKey: "project_" + n.id, parentId: e[t].id, label: n.cloudcutName, name: n.cloudcutName, workshopId: e[t].workshopId, workshopName: e[t].workshopName, isLeaf: true, fontSize: 14, type: "工单", icon: "document" });
      }), o.push({ id: e[t].id, isLast: t === e.length - 1, rowKey: "project_" + e[t].id, parentId: null, label: e[t].cloudcutName, name: e[t].cloudcutName, children: h, workshopId: e[t].workshopId, workshopName: e[t].workshopName, isLeaf: false, fontSize: 14, type: "项目", icon: "project" });
    }
    return o;
  }
  async function N() {
    try {
      const e = await re();
      V.value = e || [];
    } catch (e) {
      console.log(e, "获取车间列表失败");
    }
  }
  function H(e, o) {
    e.isLeaf && (B.value.setCurrentKey(o, true), O("order-click", e));
  }
  function W(e) {
    S.value = e, C.value = true;
  }
  async function q(e) {
    await Y.confirm("是否确认删除？一旦执行此操作将无法撤回!", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true, closeOnClickModal: false }).then(async () => {
      R.value = true, await ce([e.id]), ee.success("删除成功"), await u(), await N();
    }).catch((o) => {
      console.log(o);
    }).finally(() => {
      R.value = false;
    });
  }
  async function M() {
    T(async () => {
      await u(), await N();
    });
  }
  return D({ fetchProject: u }), (e, o) => {
    const m = E("common-button"), t = E("common-select"), h = ne, n = oe, j = te, y = se;
    return i(), I("div", null, [p("div", pe, [r(k)(d.permission.createProject) ? (i(), v(m, { key: 0, class: "filter-item", icon: "el-icon-plus", type: "success", size: "default", onClick: o[0] || (o[0] = L((l) => x.value = true, ["stop"])) }, { default: _(() => o[4] || (o[4] = [Z(" 创建项目 ")])), _: 1, __: [4] })) : z("", true), c(t, { modelValue: b.value, "onUpdate:modelValue": o[1] || (o[1] = (l) => b.value = l), options: V.value, "data-structure": { key: "workshopId", label: "workshopName", value: "workshopId" }, style: { width: "220px" }, placeholder: "全部车间", size: "default", class: "filter-item", clearable: "", onChange: u }, null, 8, ["modelValue", "options"])]), p("div", { style: f(`height:${d.maxHeight}px`) }, [J((i(), v(j, { ref_key: "treeMenuRef", ref: B, data: g.value, props: { children: "children", label: "label" }, "filter-node-method": e.filterNode, style: { height: "100%" }, indent: 20, "expand-on-click-node": "", "default-expand-all": false, "node-key": "rowKey", "show-checkbox": false, "auto-expand-parent": false, "default-expanded-keys": U.value, onNodeClick: H }, { default: _(({ node: l, data: s }) => [p("div", { style: f([{ padding: "3px", "border-radius": "3px", width: "100%", position: "relative", display: "flex", "justify-content": "space-between" }, { background: l.isCurrent ? "#ffe48d" : "" }]) }, [p("div", fe, [c(h, { style: { "margin-right": "5px" }, "icon-class": s.icon }, null, 8, ["icon-class"]), s != null && s.parentId ? (i(), I("span", { key: 0, style: f(`font-size:${s.fontSize}px;${l.isLeaf ? "" : "font-weight: bold;"}`) }, $(l.label), 5)) : (i(), I("span", { key: 1, style: f(`font-size:${s.fontSize}px;${l.isLeaf ? "" : "font-weight: bold;"}`) }, " （" + $(s.workshopName) + "）" + $(l.label), 5))]), p("div", me, [r(ae)(s.parentId) && r(k)(d.permission.createOrder) ? (i(), v(n, { key: 0, style: { "margin-right": "5px" }, size: 18, color: "#67C23A", onClick: L((A) => W(s), ["stop"]) }, { default: _(() => [c(r(Q))]), _: 2 }, 1032, ["onClick"])) : z("", true), r(k)(d.permission.del) ? (i(), v(n, { key: 1, style: f(`margin-right:${s != null && s.parentId ? "10px" : "0"} `), size: 18, color: "#F56C6C", onClick: L((A) => q(s), ["stop"]) }, { default: _(() => [c(r(X))]), _: 2 }, 1032, ["style", "onClick"])) : z("", true)])], 4)]), _: 1 }, 8, ["data", "filter-node-method", "default-expanded-keys"])), [[y, w.value]]), c(de, { visible: x.value, "onUpdate:visible": o[2] || (o[2] = (l) => x.value = l), onRefresh: M }, null, 8, ["visible"]), c(ue, { visible: C.value, "onUpdate:visible": o[3] || (o[3] = (l) => C.value = l), currentRow: S.value, onRefresh: M }, null, 8, ["visible", "currentRow"])], 4)]);
  };
} }, be = le(he, [["__scopeId", "data-v-f2de9dce"]]);
export {
  be as default
};
