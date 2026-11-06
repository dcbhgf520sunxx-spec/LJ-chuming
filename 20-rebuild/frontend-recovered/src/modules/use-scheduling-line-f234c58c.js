import { a3 as w } from "../shared/runtime.js";
import { e as j } from "./artifact-f1b0ca44.js";
import { ref as v } from "vue";
import { watch as L } from "vue";
import { watchEffect as O } from "vue";
const k = ({ queryParams: i, factoryIds: o, disabledIds: c }) => {
  const l = v(false), t = v([]), u = v([]), r = v({});
  L(() => i.value, () => {
    l.value = false, s();
  }, { immediate: true, flush: "post" }), L(() => o, () => {
    n(u.value);
  }, { deep: true });
  async function s() {
    const e = await j(i.value);
    u.value = e, l.value = true, n(u.value);
  }
  function n(e) {
    if (t.value = [], r.value = {}, l.value) {
      const { list: m, obj: f } = b(e, o.value);
      t.value = m, r.value = f;
    }
  }
  O(() => {
    p(t.value, c == null ? void 0 : c.value);
  });
  function p(e, m = []) {
    var f, g;
    for (let h = 0; h < e.length; h++) (g = (f = e[h]) == null ? void 0 : f.children) != null && g.length ? p(e[h].children, m) : e[h].disabled = !e[h].hasProcess;
  }
  function a(e) {
    return e ? t.value.filter((m) => m.id === e) : t.value;
  }
  return { getCurGroupsTree: a, groupsTree: t, groupsObj: r };
};
async function E({ productType: i, structureClassId: o, _factoryIds: c, disabledIds: l = [], mesProductEnum: t }, u = false) {
  if ((!i || !o && i !== w.MACHINE_PART.V) && !u) return { list: [], obj: {} };
  const r = await j({ productType: i, structureClassId: o, mesProductEnum: t }), s = i === w.MACHINE_PART.V || u;
  return b(r, c, l, s);
}
function b(i, o, c = [], l = false) {
  if (o != null && o.length || l) {
    let t = [];
    const u = {};
    for (let n = 0; n < i.length; n++) ((o == null ? void 0 : o.indexOf(i[n].id)) !== -1 || l) && (t = t.concat(i[n].workshopList));
    const r = [], s = t;
    for (let n = 0; n < s.length; n++) {
      const p = [], a = s[n].productionLineList;
      for (let e = 0; e < a.length; e++) u[a[e].id] = { productionLine: { id: a[e].id, name: a[e].name }, workshop: { id: s[n].id, name: s[n].name } }, p.push({ id: a[e].id, name: a[e].name, hasProcess: a[e].hasProcess, disabled: !a[e].hasProcess });
      r.push({ id: s[n].id, name: s[n].name, children: p });
    }
    return { list: r, obj: u };
  } else return { list: [], obj: {} };
}
export {
  E as m,
  k as u
};
