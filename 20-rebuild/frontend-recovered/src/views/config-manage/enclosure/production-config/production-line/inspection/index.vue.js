import { inject as H } from "vue";
import { ref as l } from "vue";
import { watch as h } from "vue";
import { nextTick as O } from "vue";
import { computed as R } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as g } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as U } from "vue";
import { createTextVNode as q } from "vue";
import { createBlock as z } from "vue";
import { ElNotification as A } from "element-plus";
import { ElTableColumn as D } from "element-plus";
import { vLoading as P } from "element-plus";
import { g as F, i as G, a as J } from "../../../../../../modules/production-line-team-8367d2ea.js";
import "../../../../../../shared/runtime.js";
const W = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(w, { expose: V }) {
  const T = H("maxHeight"), m = l([]), o = l(false), d = l(false), x = l(false), p = l(false), f = l([]), u = l([]), v = w;
  h(() => o.value, (a) => {
    a && O(() => {
      I();
    });
  });
  const i = R(() => v.line && v.line.id);
  h(() => i.value, (a) => {
    a && _();
  }, { immediate: true });
  async function _() {
    try {
      u.value = [], x.value = true;
      const a = await F({ id: i.value });
      u.value = (a.inspectionTeams || []).map((e) => (e.memberNames = e.userLinkList.map((t) => (e.teamId = t.inspectionTeamId, t.userName)).join(", "), e));
    } catch (a) {
      console.log("获取质检班组列表", a);
    } finally {
      x.value = false;
    }
  }
  async function I() {
    var a;
    try {
      f.value = [], p.value = true;
      const { content: e } = await G({ factoryId: (a = v.line) == null ? void 0 : a.factoryId });
      f.value = e.map((t) => (t.label = t.processName + " - " + t.userLinkList.map((y) => y.userName).join(", "), t)), m.value = u.value.map((t) => t.teamId);
    } catch (e) {
      console.log("获取生产线下所有质检组", e);
    } finally {
      p.value = false;
    }
  }
  async function L() {
    try {
      d.value = true, await J({ id: i.value, teamIds: m.value }), A({ title: "班组绑定成功", type: "success", duration: 2500 }), o.value = false, _();
    } catch (a) {
      console.log(a, "绑定班组");
    } finally {
      d.value = false;
    }
  }
  return V({ toAdd: () => o.value = true }), (a, e) => {
    const t = D, y = r("common-table"), j = r("common-button"), B = r("common-select"), C = r("common-dialog"), E = P;
    return N(), S("div", null, [g(n("div", null, e[2] || (e[2] = [n("div", { class: "my-code" }, "点击生产线查看详情", -1)]), 512), [[k, !i.value]]), g(n("div", null, [s(y, { ref: "tableRef", data: u.value, "max-height": U(T) + 93 }, { default: c(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), s(t, { key: "processName", prop: "processName", label: "工序名称", "min-width": "80px", "show-overflow-tooltip": "" }), s(t, { key: "memberNames", prop: "memberNames", label: "质检人员", "min-width": "160px", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height"]), s(C, { title: "选择质检", modelValue: o.value, "onUpdate:modelValue": e[1] || (e[1] = (b) => o.value = b), "before-close": () => {
      o.value = false;
    }, "close-on-click-modal": false, width: "500px" }, { titleRight: c(() => [s(j, { loading: d.value, size: "default", type: "primary", onClick: L }, { default: c(() => e[3] || (e[3] = [q(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])]), default: c(() => [g((N(), z(B, { modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (b) => m.value = b), options: f.value, type: "other", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "请选择质检人员", style: { width: "100%" } }, { empty: c(() => e[4] || (e[4] = [n("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [n("span", null, "暂无数据"), n("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])), [[E, p.value]])]), _: 1 }, 8, ["modelValue", "before-close"])], 512), [[k, i.value]])]);
  };
} };
export {
  W as default
};
