import { inject as H } from "vue";
import { ref as r } from "vue";
import { watch as w } from "vue";
import { computed as v } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as Q } from "vue";
import { withDirectives as y } from "vue";
import { vShow as _ } from "vue";
import { createElementVNode as t } from "vue";
import { createBlock as q } from "vue";
import { withCtx as s } from "vue";
import { createVNode as d } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as k } from "vue";
import { unref as T } from "vue";
import { ElNotification as z } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as P } from "element-plus";
import { a as $ } from "../../../../../modules/production-line-group-49cd597d.js";
import { aN as G, aR as J, aT as M } from "../../../../../shared/runtime.js";
import { u as W } from "../../../../../modules/use-production-team-d8043fd6.js";
const ae = { __name: "index", props: { modelValue: { type: Array, default: () => [] }, line: { type: Object, default: () => {
} }, group: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "change"], setup(N, { expose: h, emit: E }) {
  const C = [["wageQuotaType", ["parse-enum", M, { f: "SL", extra: "计价" }]]], L = H("maxHeight"), p = r([]), { loaded: R, productionTeamKV: j, productionTeam: A } = W(), l = r([]), u = r(false), c = r(false), g = E, n = N;
  w(() => n.modelValue, (a) => {
    l.value = a;
  }, { immediate: true }), w(() => u.value, (a) => {
    a && (l.value = n.modelValue);
  });
  const f = v(() => n.group && n.group.id), x = v(() => G(n.modelValue.map((a) => j.value[a]))), B = v(() => A.value.filter((a) => {
    var e, i;
    return ((e = n.line) == null ? void 0 : e.productType) & a.productType && ((i = n.line) == null ? void 0 : i.productionLineTypeEnum) & a.productionLineTypeEnum;
  }));
  async function I() {
    try {
      c.value = true, await $({ groupId: f.value, teamIds: l.value }), z({ title: "班组绑定成功", type: "success", duration: 2500 }), u.value = false, g("update:modelValue", l.value), g("change", l.value);
    } catch (a) {
      console.log(a, "绑定班组");
    } finally {
      c.value = false;
    }
  }
  return h({ toAdd: () => u.value = true }), (a, e) => {
    const i = F, S = m("common-table"), K = m("common-button"), O = m("common-select"), U = m("common-dialog"), D = P;
    return b(), Q("div", null, [y(t("div", null, e[3] || (e[3] = [t("div", { class: "my-code" }, "点击生产组查看详情", -1)]), 512), [[_, !f.value]]), y(t("div", null, [y((b(), q(S, { ref: "tableRef", data: x.value, "data-format": C, "max-height": T(L) + 135, "default-expand-all": false, "expand-row-keys": p.value, "row-key": "id", style: { width: "100%" } }, { default: s(() => [d(J, { data: x.value, "expand-row-keys": p.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (o) => p.value = o), "row-key": "id", fixed: "left" }, { default: s(({ row: o }) => [t("p", null, [e[4] || (e[4] = V(" 组员：")), t("span", null, k(o.memberNames), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), d(i, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "100px", align: "center" }, { default: s(({ row: o }) => [t("span", null, k(o.processName), 1)]), _: 1 }), d(i, { key: "leaderName", prop: "leaderName", label: "组长", "min-width": "100px" })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"])), [[D, !T(R)]]), d(U, { title: "选择班组", modelValue: u.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => u.value = o), "before-close": () => {
      u.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: s(() => [d(K, { loading: c.value, size: "default", type: "primary", onClick: I }, { default: s(() => e[5] || (e[5] = [V(" 保存 ")])), _: 1, __: [5] }, 8, ["loading"])]), default: s(() => [d(O, { modelValue: l.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => l.value = o), options: B.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择班组", style: { width: "100%" } }, { empty: s(() => e[6] || (e[6] = [t("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [t("span", null, "暂无数据"), t("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[_, f.value]])]);
  };
} };
export {
  ae as default
};
