import { ref as h } from "vue";
import { inject as B } from "vue";
import { computed as H } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as C } from "vue";
import { createBlock as D } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as l } from "vue";
import { unref as d } from "vue";
import { createElementVNode as n } from "vue";
import { isRef as L } from "vue";
import { ElTag as Q } from "element-plus";
import { a as q } from "../../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { _ as z, o as E, u as O, z as F, p as M } from "../../../../../shared/runtime.js";
const A = { class: "print-table" }, U = { __name: "production-scheduling-list", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object } }, emits: ["update:visible"], setup(p, { emit: k }) {
  const T = k, v = p, m = h(false), w = h([]), y = h(), R = B("query"), b = H(() => {
    var r, o;
    return { ...R, projectId: ((o = (r = v.currentRow) == null ? void 0 : r.project) == null ? void 0 : o.id) || void 0 };
  }), { maxHeight: W } = E({ mainBox: ".loss-statistics-v2-production-scheduling-list", extraBox: [".el-drawer__header", ".print-table"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => y.value.loaded), { visible: g, handleClose: N } = O({ emit: T, props: v, field: "visible", showHook: V });
  async function S() {
    let r = [];
    m.value = true;
    try {
      const { content: o = [] } = await q({ ...b.value });
      r = o || [];
    } catch (o) {
      console.log(o);
    } finally {
      w.value = r, m.value = false;
    }
  }
  function V() {
    S();
  }
  function j({ columns: r, data: o }) {
    const s = [];
    return r.forEach((c, t) => {
      if (t === 0) {
        s[t] = "合计";
        return;
      }
      if (["taskQuantity", "totalWeight"].includes(c.property)) {
        let u = 0;
        o.forEach((_) => {
          u += Number(_[c.property]) || 0;
        }), c.property === "totalWeight" ? s[t] = u.toFixed(3) : s[t] = u.toString();
      } else s[t] = "";
    }), [s];
  }
  return (r, o) => {
    const s = Q, c = f("print-table"), t = f("vxe-column"), u = f("vxe-table"), _ = f("common-drawer");
    return C(), D(_, { ref_key: "drawerRef", ref: y, title: "排产清单", modelValue: d(g), "onUpdate:modelValue": o[0] || (o[0] = (e) => L(g) ? g.value = e : null), "before-close": d(N), "custom-class": "loss-statistics-v2-production-scheduling-list", size: "50%" }, { titleAfter: a(() => [i(s, { class: "filter-item" }, { default: a(() => {
      var e;
      return [x(" 项目：" + l(d(F)((e = p.currentRow) == null ? void 0 : e.project) || "-"), 1)];
    }), _: 1 }), i(s, { class: "filter-item" }, { default: a(() => {
      var e;
      return [x(" 排产总量（kg）：" + l(((e = p.currentRow) == null ? void 0 : e.schedulingWeight) ?? "-"), 1)];
    }), _: 1 })]), content: a(() => [n("div", A, [i(c, { "api-key": "lossStatisticsSchedulingDetail", params: b.value, type: "warning", class: "filter-item" }, null, 8, ["params"])]), i(u, { border: "", "show-header-overflow": "", "show-footer-overflow": "", "show-footer": "", stripe: "", ref: "tableRef", data: w.value, "max-height": d(W), loading: m.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "row-config": { isHover: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "show-overflow": "tooltip", "footer-method": j }, { default: a(() => [i(t, { type: "seq", title: "序号", align: "center", width: "60", fixed: "left" }), i(t, { title: "排产日期", field: "createTime", key: "createTime", align: "center" }, { default: a((e) => [n("div", null, l(e.row.createTime ? d(M)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), i(t, { title: "单体", field: "name", key: "name", align: "center" }, { default: a((e) => [n("div", null, l(e.row.name || "-"), 1)]), _: 1 }), i(t, { title: "编号", field: "serialNumber", key: "serialNumber", align: "center" }, { default: a((e) => [n("div", null, l(e.row.serialNumber || "-"), 1)]), _: 1 }), i(t, { title: "规格", field: "specification", key: "specification", align: "center" }, { default: a((e) => [n("div", null, l(e.row.specification || "-"), 1)]), _: 1 }), i(t, { title: "数量", field: "taskQuantity", key: "taskQuantity", align: "center" }, { default: a((e) => [n("div", null, l(e.row.taskQuantity ?? "-"), 1)]), _: 1 }), i(t, { title: "单重", field: "netWeight", key: "netWeight", align: "center" }, { default: a((e) => [n("div", null, l(e.row.netWeight ?? "-"), 1)]), _: 1 }), i(t, { title: "总重", field: "totalWeight", key: "totalWeight", align: "center" }, { default: a((e) => [n("div", null, l(e.row.totalWeight ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, P = z(U, [["__scopeId", "data-v-d4d8cbaf"]]);
export {
  P as default
};
